package org.zkh.hotnews.common.exception;

import org.zkh.hotnews.common.result.ResponseStatusEnum;

public class BizException extends RuntimeException{
    private ResponseStatusEnum responseStatusEnum;

    public BizException(ResponseStatusEnum responseStatusEnum) {
        super("异常状态码为：" + responseStatusEnum.status()
                + "；具体异常信息为：" + responseStatusEnum.msg());
        this.responseStatusEnum = responseStatusEnum;
    }

    public ResponseStatusEnum getResponseStatusEnum() {
        return responseStatusEnum;
    }

    public void setResponseStatusEnum(ResponseStatusEnum responseStatusEnum) {
        this.responseStatusEnum = responseStatusEnum;
    }
}
