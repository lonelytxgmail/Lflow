package com.lflow.flow;

import com.lflow.commons.exception.ResourceNotFoundException;
import com.lflow.commons.http.PageResult;
import com.lflow.commons.http.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Title: controller
 * @Package com.lflow
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/7 11:05
 */

@RestController
@RequestMapping("/api/v1")
public class FlowController {
    private final FlowService flowService;

    public FlowController(FlowService flowService) {
        this.flowService = flowService;
    }

    @GetMapping("flow")
    public PageResult<List> listFlow(FlowRequest flowRequest) {
        List<Flow> flowList = flowService.findList(flowRequest);
        return PageResult.of(flowList);
    }

    @PostMapping("flow")
    public Result addFlow(@RequestBody Flow flow) {
        flowService.addOne(flow);
        return Result.of(flow);
    }


    @PutMapping("flow")
    public Result updateFlow(@RequestBody Flow flow) {
        flow.setUpdateDate(new Date());
        flowService.update(flow);
        return Result.of(flow);
    }

    @DeleteMapping("flow")
    public Result deleteFlow(@RequestBody Flow flow) {

        String id = flow.getId();
        flow = flowService.findById(id);
        if (flow == null) {
            throw new ResourceNotFoundException("id", id);
        }
        String s = flowService.deleteById(id);
        return Result.of(s);
    }


}
