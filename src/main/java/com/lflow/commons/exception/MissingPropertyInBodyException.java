package com.lflow.commons.exception;

import com.lflow.commons.http.ApiError;

/**
 * @Description:
 * @Title: InvalidParam
 * @Package com.lflow.commons.exception
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/12 17:53
 */


public class MissingPropertyInBodyException extends FlowException {

    public MissingPropertyInBodyException(String name) {
        super(
                ApiError.MISSING_PROPERTY_IN_BODY,
                String.format("Missing required %s property in request body", name));
    }
}
