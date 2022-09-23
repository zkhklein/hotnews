package org.zkh.hotnews.common.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author S9049660
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("attitude_to_comment")
public class AttitudeToComment {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Integer attitude;
    private Long userId;
    private Long commentId;
}
