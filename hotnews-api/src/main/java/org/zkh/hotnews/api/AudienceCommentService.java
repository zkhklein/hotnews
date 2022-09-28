package org.zkh.hotnews.api;

import org.zkh.hotnews.common.data.dto.CommentDTO;

import java.util.List;


/**
 * @author S9049660
 */
public interface AudienceCommentService {

    public Boolean sendComment(CommentDTO commentDTO) throws Exception;

    public Integer likeComment(Long commentId, Long userId) throws Exception;

    public Integer dislikeComment(Long commentId, Long userId) throws Exception;

    public String viewComment(Long commentId) throws Exception;
}
