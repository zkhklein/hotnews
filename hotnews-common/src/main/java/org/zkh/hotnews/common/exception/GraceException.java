package org.zkh.hotnews.common.exception;

import org.zkh.hotnews.common.result.ResponseStatusEnum;

/**
 * 优雅的处理异常，统一封装
 *
 * @author zkh
 */
public class GraceException {

    /**
     * @param responseStatusEnum
     */
    public static void display(ResponseStatusEnum responseStatusEnum) {
        throw new BizException(responseStatusEnum);
    }
}
