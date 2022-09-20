﻿package org.zkh.hotnews.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("comment")
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String password;
}
