package org.zkh.hotnews.provider.audience.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.zkh.hotnews.api.AudienceViewService;
import org.zkh.hotnews.common.cache.RedisUtil;
import org.zkh.hotnews.common.data.entity.AttitudeToPaper;
import org.zkh.hotnews.common.data.entity.Paper;
import org.zkh.hotnews.common.data.entity.User;
import org.zkh.hotnews.common.service.AttitudeToPaperDataService;
import org.zkh.hotnews.common.service.PaperDataService;
import org.zkh.hotnews.common.service.UserDataService;

import static org.zkh.hotnews.provider.audience.constant.RedisConstant.PAPER_USER_ATTITUDE;
import static org.zkh.hotnews.provider.author.constant.RedisConstant.*;

/**
 * @author S9049660
 */
@Service
public class AudienceViewServiceImpl implements AudienceViewService {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    PaperDataService paperDataService;
    @Autowired
    UserDataService userDataService;

    @Autowired
    AttitudeToPaperDataService attitudeToPaperDataService;

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
        String content = (String) redisUtil.get(PAPER_USER_ATTITUDE + paperId + ":" + userId);
        if (content == null) {
            content = String.valueOf(attitudeToPaperDataService.lambdaQuery().eq(AttitudeToPaper::getPaperId, paperId).eq(AttitudeToPaper::getUserId, userId).one().getAttitude());
            if (content == null) {
                content = "0";
                return content;
            } else {
                redisUtil.set(PAPER_USER_ATTITUDE + paperId + ":" + userId, content);
            }
        }
        return content;
    }

    @Override
    public Integer doLikePaper(Long paperId, Long userId) throws Exception {
        return null;
    }

    @Override
    public Integer doDislikePaper(Long paperId, Long userId) throws Exception {
        return null;
    }
}
