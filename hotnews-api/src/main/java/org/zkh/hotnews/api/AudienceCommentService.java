package org.zkh.hotnews.api;

import org.zkh.hotnews.data.dto.CommentDTO;

import java.util.List;


/**
 * @author S9049660
 */
public interface AudienceCommentService {

    public Integer sendComment(CommentDTO commentDTO) throws Exception;

    public Integer likeComment(Long commentId,Long userId) throws Exception;

    public Integer dislikeComment(Long commentId,Long userId) throws Exception;

    public List<CommentDTO> viewComments(Long paperId) throws Exception;
}
