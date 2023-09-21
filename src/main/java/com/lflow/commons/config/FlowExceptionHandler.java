package com.lflow.commons.config;

import com.lflow.commons.exception.FlowException;
import com.lflow.commons.http.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @Description:
 * @Title: FlowExceptionHandler
 * @Package com.lflow.commons.config
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/7 22:08
 */
@Slf4j
@ControllerAdvice
public class FlowExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleFlowException(Exception ex, WebRequest request) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        if (ex instanceof FlowException){
            FlowException e =(FlowException) ex;
            return this.handleExceptionInternal(e,e.getApiError(),headers,e.getStatus(),request );
        }
        return this.handleExceptionInternal(ex,null,headers,HttpStatus.INTERNAL_SERVER_ERROR,request);
    }
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (body==null){
            body = new ApiError().message(ex.getMessage()).error(ApiError.INTERNAL_ERROR);

        }
        if (body instanceof ApiError){
            ApiError apiError = (ApiError)body;
            apiError.setStatus(status.value());
            request.getContextPath();
            ServletWebRequest request1 = (ServletWebRequest) request;
            apiError.setPath(request1.getRequest().getRequestURI());
        }
        log.error("返回异常:{}",ex.getMessage());
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

}
