package org.zkh.hotnews.common.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class AttitudeToPaperDTO {
    private Integer attitude;
    private Integer likeChange;
    private Integer dislikeChange;
    private Long userId;
    private Long paperId;

    private Boolean exist;
}
