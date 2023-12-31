package com.lflow.flow.node.data;

import com.lflow.commons.exception.MissingPropertyInBodyException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Title: NodeDataService
 * @Package com.lflow.flow.node.data
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/19 18:54
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class NodeDataService {
    private final NodeDataMapper nodeDataMapper;
    public void saveNodeData(List<NodeData> list) {
        list.forEach(this::check);
        nodeDataMapper.saveNodeDate(list);
    }

    public List<NodeData> getNodeData(String flowId,String version) {
        if (version!=null){
            return nodeDataMapper.findVersionsByFlowIdAndVersion(flowId, version);
        }
        return nodeDataMapper.findByFlowId(flowId);
    }
    public List<String> getVersion(String flowId){
        return  nodeDataMapper.findVersionsByFlowId(flowId);
    }
    @Transactional(rollbackFor = Exception.class)
    public void updateNodeData(List<NodeData> list) {
        String id = list.get(0).getFlowId();
        nodeDataMapper.deleteByFlowId(id);
        nodeDataMapper.saveNodeDate(list);
    }
    private void check(NodeData nodeData) {
        if (nodeData.getId() == null) {
            throw new MissingPropertyInBodyException("id");
        }
        if (nodeData.getFlowId() == null) {
            throw new MissingPropertyInBodyException("flowId");
        }
    }
}
