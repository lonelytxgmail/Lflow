package com.lflow.flow;

import com.lflow.commons.http.PageRequest;
import lombok.Data;

/**
 * @Description:
 * @Title: FlowRequest
 * @Package com.lflow.entity
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/7 16:58
 */

@Data
public class FlowRequest extends PageRequest {
    private String name;
    private Flow.Status status;
}
