package com.lflow.commons.http;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Title: Result
 * @Package com.lflow.commons
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/7 17:00
 */

@Data
@NoArgsConstructor
public class Result<T> {
    private T result;

    public Result(T result) {
        this.result = result;
    }

    public static <T> Result<T> of(T result) {
        return new Result<T>(result);
    }

    public static  Result<String> ok() {
        return new Result<>("ok");
    }
}
