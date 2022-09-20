package org.zkh.hotnews.common.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class RequestDTO {
    private Map<String,Object> paramMap;
    private String signature;
}
