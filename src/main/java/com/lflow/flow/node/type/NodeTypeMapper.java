package com.lflow.flow.node.type;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description:
 * @Title: NodeTypeParamMapper
 * @Package com.lflow.flow.node.type
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/19 18:26
 */

@Mapper
public interface NodeTypeMapper {

    @Select("select * from eda_flow_node_type")
    public List<NodeType> findAll();
}
