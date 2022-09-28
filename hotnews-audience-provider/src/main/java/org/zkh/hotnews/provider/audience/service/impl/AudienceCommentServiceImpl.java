package org.zkh.hotnews.provider.audience.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.zkh.hotnews.api.AudienceCommentService;
import org.zkh.hotnews.common.cache.RedisUtil;
import org.zkh.hotnews.common.data.dto.CommentDTO;
import org.zkh.hotnews.common.data.entity.Comment;
import org.zkh.hotnews.common.id.SnowFlakeIdUtil;
import org.zkh.hotnews.common.service.CommentDataService;

import static org.zkh.hotnews.provider.audience.constant.RedisConstant.COMMENT_CONTENT;
import static org.zkh.hotnews.provider.audience.constant.RedisConstant.COMMENT_LIST;

@Service
@Slf4j
public class AudienceCommentServiceImpl implements AudienceCommentService {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    CommentDataService commentDataService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    RedisUtil redisUtil;
    private final Gson gson = new GsonBuilder().create();

    @Override
    public Boolean sendComment(CommentDTO commentDTO) throws Exception {
        try {
            commentDTO.setId(SnowFlakeIdUtil.generateId());
            //生产消息
            kafkaTemplate.send("author", "COMMENT_SEND" + ":" + commentDTO.getId().toString(), gson.toJson(commentDTO)).addCallback(success -> {
                // 消息发送到的topic
                assert success != null;
                String topic = success.getRecordMetadata().topic();
                // 消息发送到的分区
                int partition = success.getRecordMetadata().partition();
                // 消息在分区内的offset
                long offset = success.getRecordMetadata().offset();
                log.info("发送消息成功:" + topic + "-" + partition + "-" + offset);
                if (commentDTO.getParent() == null && commentDTO.getParent() <= 0) {
                    redisTemplate.opsForList().leftPush(COMMENT_LIST + commentDTO.getPaperId() + ":" + "0", commentDTO.getId());
                    redisUtil.set(COMMENT_CONTENT + commentDTO.getId(), commentDTO.getContent());

                } else {
                    redisTemplate.opsForList().leftPush(COMMENT_LIST + commentDTO.getPaperId() + ":" + commentDTO.getParent(), commentDTO.getId());
                    redisUtil.set(COMMENT_CONTENT + commentDTO.getId(), commentDTO.getContent());
                }
            }, failure -> {
                log.info("发送消息失败:" + failure.getMessage());
            });

            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    @Override
    public Integer likeComment(Long commentId, Long userId) throws Exception {
        return null;
    }

    @Override
    public Integer dislikeComment(Long commentId, Long userId) throws Exception {
        return null;
    }

    @Override

    @Cacheable(cacheNames = "paper_content", key = "#commentId")
    public String viewComment(Long commentId) throws Exception {
        String content = (String) redisUtil.get(COMMENT_CONTENT + commentId);
        if (content == null) {
            content = commentDataService.lambdaQuery().eq(Comment::getId, commentId).one().getContent();
            redisUtil.set(COMMENT_CONTENT + commentId, content);
        }
        return content;

    }
}
