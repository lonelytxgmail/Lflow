package com.lflow.commons.exception;

import com.lflow.commons.http.ApiError;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @Description:
 * @Title: FlowException
 * @Package com.lflow.exception
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/7 22:05
 */

@Data
public class FlowException extends RuntimeException{
    private String error;
    private String message;
    private HttpStatus status;

    public FlowException(String message, String  apiError) {
        super(message);
        this.message = message;
        this.error = apiError;
        this.status = HttpStatus.BAD_REQUEST;

    }
    public ApiError getApiError(){
        new ApiError();
        return new ApiError().error(error);
    }
}
