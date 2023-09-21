package com.lflow.flow.node.type.params;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description:
 * @Title: NodeTypeParamMapper
 * @Package com.lflow.flow.node.type.params
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/21 10:34
 */

@Mapper
public interface NodeTypeParamMapper {
    @Select("select * from l_flow.eda_flow_node_type_param where type_id=#{typeId}")
    List<NodeTypeParam> findByTypeId(Integer typeId);
}
