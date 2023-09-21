package com.lflow.commons.exception;

import com.lflow.commons.http.ApiError;

/**
 * @Description:
 * @Title: ResourceNotFoundException
 * @Package com.lflow.commons.exception
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/14 16:41
 */

public class ResourceNotFoundException extends FlowException {
    public ResourceNotFoundException(String name,Object value) {
        super(String.format("The %s %s resource not Found ",name,value),ApiError.RESOURCE_NOT_FOUND);
    }

}
