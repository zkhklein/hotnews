package org.zkh.hotnews.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author S9049660
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("comment")
public class Comment {
    @TableId(type= IdType.AUTO)
    private Long id;
    private Long authorId;
    private String content;
    private Long parent;
    private Integer likeNum;
    private Integer disLikeNum;
}
