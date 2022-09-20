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
@TableName("attitude_to_paper")
public class AttitudeToPaper {
    @TableId(type= IdType.AUTO)
    private Long id;
    private Integer attitude;
    private Long userId;
    private Long paperId;
}
