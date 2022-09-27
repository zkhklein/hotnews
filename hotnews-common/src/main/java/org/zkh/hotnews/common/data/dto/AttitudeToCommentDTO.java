package org.zkh.hotnews.common.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AttitudeToCommentDTO {

    private Integer attitude;
    private Integer likeChange;
    private Integer dislikeChange;
    private Long userId;

    private Long commentId;
}
