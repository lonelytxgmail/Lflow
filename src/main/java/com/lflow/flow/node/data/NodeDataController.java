package com.lflow.flow.node.data;

import com.lflow.commons.exception.InvalidStatesException;
import com.lflow.commons.exception.MissingPropertyInBodyException;
import com.lflow.commons.http.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Title: NodeDataController
 * @Package com.lflow.flow.node.data
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/19 18:50
 */


@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
@Slf4j
public class NodeDataController {
    private final NodeDataService nodeDataService;

    @PostMapping("/node/data")
    public Result<String> setNodeData(@RequestBody List<NodeData> list) {
        checkBody(list);
        nodeDataService.saveNodeData(list);
        return Result.ok();
    }

    private void checkBody(List<NodeData> list) {
        if (CollectionUtils.isEmpty(list)) {
            throw new InvalidStatesException("the flow data is empty");
        }
        for (NodeData nodeData : list) {
            if (nodeData.getId() == null) {
                throw new MissingPropertyInBodyException("id");
            }
            if (nodeData.getFlowId() == null) {
                throw new MissingPropertyInBodyException("flowId");
            }
        }
    }

    @GetMapping("/node/data")
    public Result<List<NodeData>> setNodeData(@RequestParam String flowId) {
        log.info(flowId);
        List<NodeData> list = nodeDataService.findByFlowId(flowId);
        return Result.of(list);
    }


    @GetMapping("/node/data/version")
    public Result<List<String>> getVersionList(@RequestParam String flowId) {
        log.info(flowId);
        List<NodeData> list = nodeDataService.findByFlowId(flowId);
        List<String> collect = list.stream().map(NodeData::getVersion).collect(Collectors.toList());
        return Result.of(collect);
    }

    @PostMapping("/node/data/version")
    public Result<String> setVersion(@RequestParam String version, @RequestBody List<NodeData> list) {
        if (version.length() > 32) {
            throw new InvalidStatesException("The version name is too long");
        }
        checkBody(list);
        list.forEach(nodeData -> nodeData.setVersion(version));
        nodeDataService.updateNodeData(list);
        return Result.ok();
    }
}
