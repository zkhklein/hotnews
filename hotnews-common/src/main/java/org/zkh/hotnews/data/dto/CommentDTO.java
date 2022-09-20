package org.zkh.hotnews.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDTO implements Serializable {
    private Long id;
    private Long authorId;
    private String content;
    private Long parent;
    private Integer likeNum;
    private Integer disLikeNum;
}
