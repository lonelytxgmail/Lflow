package com.lflow.commons.exception;

import com.lflow.commons.http.ApiError;

/**
 * @Description:
 * @Title: InternalException
 * @Package com.lflow.commons.exception
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/21 11:37
 */

public class InternalException extends FlowException{
    public InternalException(String message) {
        super(message, ApiError.INTERNAL_ERROR);
    }
}
