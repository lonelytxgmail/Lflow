package com.lflow.commons.http;

import lombok.Data;

/**
 * @Description:
 * @Title: Request
 * @Package com.lflow.commons
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/7 17:05
 */


@Data
public class PageRequest {
     private int pageSize =5;
     private int pageNum = 1;
}
