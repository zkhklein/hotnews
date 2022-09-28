package org.zkh.hotnews.provider.audience.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.zkh.hotnews.api.AudienceViewService;
import org.zkh.hotnews.common.cache.RedisUtil;
import org.zkh.hotnews.common.data.dto.AttitudeToPaperDTO;
import org.zkh.hotnews.common.data.entity.AttitudeToPaper;
import org.zkh.hotnews.common.data.entity.Paper;
import org.zkh.hotnews.common.data.entity.User;
import org.zkh.hotnews.common.service.AttitudeToPaperDataService;
import org.zkh.hotnews.common.service.PaperDataService;
import org.zkh.hotnews.common.service.UserDataService;

import static org.zkh.hotnews.provider.audience.constant.RedisConstant.PAPER_USER_ATTITUDE_DISLIKE;
import static org.zkh.hotnews.provider.audience.constant.RedisConstant.PAPER_USER_ATTITUDE_LIKE;
import static org.zkh.hotnews.provider.author.constant.RedisConstant.*;

/**
 * @author S9049660
 */
@Service
@Slf4j
public class AudienceViewServiceImpl implements AudienceViewService {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    PaperDataService paperDataService;
    @Autowired
    UserDataService userDataService;
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    AttitudeToPaperDataService attitudeToPaperDataService;
    private final Gson gson = new GsonBuilder().create();

    @Override
    @Cacheable(cacheNames = "paper_content", key = "#paperId")
    public String viewPaperContent(Long paperId) throws Exception {
        String content = (String) redisUtil.get(PAPER_CONTENT + paperId);
        if (content == null) {
            content = paperDataService.lambdaQuery().eq(Paper::getId, paperId).one().getContent();
            redisUtil.set(PAPER_CONTENT + paperId, content);
        }
        return content;
    }

    @Override
    @Cacheable(cacheNames = "paper_title", key = "#paperId")
    public String viewPaperTitle(Long paperId) throws Exception {
        String content = (String) redisUtil.get(PAPER_TITLE + paperId);
        if (content == null) {
            content = paperDataService.lambdaQuery().eq(Paper::getId, paperId).one().getTitle();
            redisUtil.set(PAPER_TITLE + paperId, content);
        }
        return content;
    }

    @Override
    @Cacheable(cacheNames = "paper_author_name", key = "#paperId")
    public String viewPaperAuthor(Long paperId) throws Exception {
        String content = (String) redisUtil.get(PAPER_AUTHOR_NAME + paperId);
        if (content == null) {
            content = userDataService.lambdaQuery().eq(User::getId, paperDataService.lambdaQuery().eq(Paper::getId, paperId).one().getAuthorId()).one().getName();
            redisUtil.set(PAPER_AUTHOR_NAME + paperId, content);
        }
        return content;
    }

    @Override
    public String viewPaperLikeNum(Long paperId) throws Exception {
        String content = (String) redisUtil.get(PAPER_LIKE_NUM + paperId);
        if (content == null) {
            content = paperDataService.lambdaQuery().eq(Paper::getId, paperId).one().getLikeNum().toString();
            redisUtil.set(PAPER_LIKE_NUM + paperId, content);
        }
        return content;
    }

    @Override
    public String viewPaperDislikeNum(Long paperId) throws Exception {
        String content = (String) redisUtil.get(PAPER_DISLIKE_NUM + paperId);
        if (content == null) {
            content = paperDataService.lambdaQuery().eq(Paper::getId, paperId).one().getDislikeNum().toString();
            redisUtil.set(PAPER_LIKE_NUM + paperId, content);
        }
        return content;
    }

    @Override
    public String viewPaperCommentNum(Long paperId) throws Exception {
        String content = (String) redisUtil.get(PAPER_COMMENT_NUM + paperId);
        if (content == null) {
            content = paperDataService.lambdaQuery().eq(Paper::getId, paperId).one().getCommentNum().toString();
            redisUtil.set(PAPER_AUTHOR_NAME + paperId, content);
        }
        return content;
    }

    @Override
    public String viewAttitudeToPaper(Long paperId, Long userId) throws Exception {
        String lcontent = (String) redisUtil.get(PAPER_USER_ATTITUDE_LIKE + paperId + ":" + userId);
        String dcontent = (String) redisUtil.get(PAPER_USER_ATTITUDE_DISLIKE + paperId + ":" + userId);
        if ((lcontent == null && dcontent == null)) {
            String content = String.valueOf(attitudeToPaperDataService.lambdaQuery().eq(AttitudeToPaper::getPaperId, paperId).eq(AttitudeToPaper::getUserId, userId).one().getAttitude());
            if (content == null) {
                content = "0";
                return content;
            } else if (content.equals("1")) {
                redisUtil.set(PAPER_USER_ATTITUDE_LIKE + paperId + ":" + userId, "1");
            } else {
                redisUtil.set(PAPER_USER_ATTITUDE_DISLIKE + paperId + ":" + userId, "1");
            }
        }
        lcontent = (String) redisUtil.get(PAPER_USER_ATTITUDE_LIKE + paperId + ":" + userId);
        dcontent = (String) redisUtil.get(PAPER_USER_ATTITUDE_DISLIKE + paperId + ":" + userId);
        return lcontent != null ? lcontent : dcontent;
    }

    @Override
    public Boolean doLikePaper(AttitudeToPaperDTO attitudeToPaperDTO) throws Exception {
        if (attitudeToPaperDTO.getExist()) {
            String content = (String) redisUtil.get(PAPER_USER_ATTITUDE_LIKE + attitudeToPaperDTO.getPaperId() + ":" + attitudeToPaperDTO.getUserId());
            if (content == null) {
                //send
                if (attitudeToPaperDataService.lambdaQuery()
                        .eq(AttitudeToPaper::getPaperId, attitudeToPaperDTO.getPaperId())
                        .eq(AttitudeToPaper::getUserId, attitudeToPaperDTO.getUserId()).one() != null) {
                    redisUtil.set(PAPER_USER_ATTITUDE_LIKE + attitudeToPaperDTO.getPaperId() + ":" + attitudeToPaperDTO.getUserId(), "1");
                }
            }

            kafkaTemplate.send("author", "PAPER_ATTITUDE" + ":" + attitudeToPaperDTO.getUserId(), gson.toJson(attitudeToPaperDTO)).addCallback(success -> {
                // 消息发送到的topic
                redisUtil.set(PAPER_USER_ATTITUDE_LIKE + attitudeToPaperDTO.getPaperId() + ":" + attitudeToPaperDTO.getUserId(), "1");
                redisUtil.delete(PAPER_USER_ATTITUDE_DISLIKE + attitudeToPaperDTO.getPaperId() + ":" + attitudeToPaperDTO.getUserId());
            }, failure -> {
                log.info("发送消息失败:" + failure.getMessage());
            });

        } else {
            kafkaTemplate.send("author", "PAPER_ATTITUDE" + ":" + attitudeToPaperDTO.getUserId(), gson.toJson(attitudeToPaperDTO)).addCallback(success -> {
                // 消息发送到的topic
                redisUtil.set(PAPER_USER_ATTITUDE_LIKE + attitudeToPaperDTO.getPaperId() + ":" + attitudeToPaperDTO.getUserId(), "1");
            }, failure -> {
                log.info("发送消息失败:" + failure.getMessage());
            });

        }


        return Boolean.TRUE;
    }

    @Override
    public Boolean doDislikePaper(AttitudeToPaperDTO attitudeToPaperDTO) throws Exception {
        if (attitudeToPaperDTO.getExist()) {
            String content = (String) redisUtil.get(PAPER_USER_ATTITUDE_DISLIKE + attitudeToPaperDTO.getPaperId() + ":" + attitudeToPaperDTO.getUserId());
            if (content == null) {
                //send
                if (attitudeToPaperDataService.lambdaQuery()
                        .eq(AttitudeToPaper::getPaperId, attitudeToPaperDTO.getPaperId())
                        .eq(AttitudeToPaper::getUserId, attitudeToPaperDTO.getUserId()).one() != null) {
                    redisUtil.set(PAPER_USER_ATTITUDE_DISLIKE + attitudeToPaperDTO.getPaperId() + ":" + attitudeToPaperDTO.getUserId(), "1");
                }
            }

            kafkaTemplate.send("author", "PAPER_ATTITUDE" + ":" + attitudeToPaperDTO.getUserId(), gson.toJson(attitudeToPaperDTO)).addCallback(success -> {
                // 消息发送到的topic
                redisUtil.set(PAPER_USER_ATTITUDE_DISLIKE + attitudeToPaperDTO.getPaperId() + ":" + attitudeToPaperDTO.getUserId(), "1");
                redisUtil.delete(PAPER_USER_ATTITUDE_LIKE + attitudeToPaperDTO.getPaperId() + ":" + attitudeToPaperDTO.getUserId());
            }, failure -> {
                log.info("发送消息失败:" + failure.getMessage());
            });

        } else {
            kafkaTemplate.send("author", "PAPER_ATTITUDE" + ":" + attitudeToPaperDTO.getUserId(), gson.toJson(attitudeToPaperDTO)).addCallback(success -> {
                // 消息发送到的topic
                redisUtil.set(PAPER_USER_ATTITUDE_DISLIKE + attitudeToPaperDTO.getPaperId() + ":" + attitudeToPaperDTO.getUserId(), "1");
            }, failure -> {
                log.info("发送消息失败:" + failure.getMessage());
            });
        }
        return Boolean.TRUE;
    }
}
