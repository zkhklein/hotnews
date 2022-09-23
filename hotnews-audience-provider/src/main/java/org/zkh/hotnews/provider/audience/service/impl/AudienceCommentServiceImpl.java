package org.zkh.hotnews.provider.audience.service.impl;

import org.springframework.stereotype.Service;
import org.zkh.hotnews.api.AudienceCommentService;
import org.zkh.hotnews.common.data.dto.CommentDTO;

import java.util.List;

@Service
public class AudienceCommentServiceImpl implements AudienceCommentService {
    @Override
    public Integer sendComment(CommentDTO commentDTO) throws Exception {
        return null;
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
    public List<CommentDTO> viewComments(Long paperId) throws Exception {
        return null;
    }
}
