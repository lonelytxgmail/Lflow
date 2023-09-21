package com.lflow.commons.http;

import com.github.pagehelper.Page;
import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Title: Result
 * @Package com.lflow.commons
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/7 17:00
 */
@Data
public class PageResult<T> extends Result<T> {
    private T result;
    private long total;
    private int pageSize;
    private int pageNum;


    public static <T> PageResult<List> of(List<T> list) {
        PageResult<List> pageResult = new PageResult<>();
        pageResult.setResult(list);
        pageResult.setPageSize(((Page) list).getPageSize());
        pageResult.setPageNum(((Page) list).getPageNum());
        pageResult.setTotal(((Page) list).getTotal());
        return pageResult;
    }

}
