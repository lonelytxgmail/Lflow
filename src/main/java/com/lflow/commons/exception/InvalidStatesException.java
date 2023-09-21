package com.lflow.commons.exception;

import com.lflow.commons.http.ApiError;

/**
 * @Description:
 * @Title: InvalidParam
 * @Package com.lflow.commons.exception
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/12 17:53
 */


public class InvalidStatesException extends FlowException {
    public InvalidStatesException(String message) {
        super(ApiError.INVALID_STATE, message);
    }

    public InvalidStatesException(String name, Object value) {
        super(
                ApiError.INVALID_STATE,
                String.format("The %s parameter value %s invalid", name, value));
    }
}
