package org.zkh.hotnews.common.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("paper")
@Accessors(chain = true)
public class Paper {

    @TableId(type = IdType.INPUT)
    private Long id;
    private String title;
    private String content;
    private Long authorId;
    private Integer likeNum;
    private Integer dislikeNum;
    private Integer commentNum;
}
