﻿package org.zkh.hotnews.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("paper")
public class Paper {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String title;
    private String content;
    private Long authorId;
    private Integer likeNum;
    private Integer dislikeNum;
    private Integer commentNum;
}
