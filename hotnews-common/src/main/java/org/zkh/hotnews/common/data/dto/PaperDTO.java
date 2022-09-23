package org.zkh.hotnews.common.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaperDTO implements Serializable {
    private Long id;
    private String title;
    private String content;
    private Long authorId;
    private Integer likeNum;
    private Integer dislikeNum;
    private Integer commentNum;
}
