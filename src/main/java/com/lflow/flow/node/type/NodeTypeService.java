package com.lflow.flow.node.type;

import com.lflow.flow.node.type.params.NodeTypeParam;
import com.lflow.flow.node.type.params.NodeTypeParamMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Title: NodeTypeService
 * @Package com.lflow.flow.node.type
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/19 18:23
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class NodeTypeService {
    private final NodeTypeMapper nodeTypeMapper;
    private final NodeTypeParamMapper nodeTypeParamMapper;
    private static final List<String> MENU = Arrays.asList("基础", "运算", "解析", "网络", "数据库", "子流程");

    public Document findAll() {
        List<NodeType> list = nodeTypeMapper.findAll();
        list.forEach(this::mergeNodeTypeParams);
        Document result = new Document();
        MENU.forEach(k -> result.append(k, list.stream().filter(nodeType -> nodeType.getMenu().equals(nodeType.getMenu()))));
        return result;
    }
    private  void mergeNodeTypeParams(NodeType nodeType){
        Integer id = nodeType.getId();
        List<NodeTypeParam> list = nodeTypeParamMapper.findByTypeId(id);
        nodeType.setParams(list);

    }
}
