package org.zkh.hotnews.common.data.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AttitudeCountDTO {
    Long id;
    private Integer likeNum;
    private Integer disLikeNum;
}
