package com.lflow.commons.exception;

import com.lflow.commons.http.ApiError;

/**
 * @Description:
 * @Title: InvalidParam
 * @Package com.lflow.commons.exception
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/12 17:53
 */


public class InvalidParameterException extends FlowException {
    public InvalidParameterException(String message) {
        super(ApiError.INVALID_PARAMETER, message);
    }

    public InvalidParameterException(String name, Object value) {
        super(
                ApiError.INVALID_PARAMETER,
                String.format("The %s parameter value %s invalid", name, value));
    }
}
