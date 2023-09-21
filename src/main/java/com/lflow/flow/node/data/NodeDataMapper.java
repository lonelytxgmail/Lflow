package com.lflow.flow.node.data;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description:
 * @Title: NodeDataMapper
 * @Package com.lflow.flow.node.data
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/19 19:17
 */
@Mapper
public interface NodeDataMapper {

    @Insert("<script>INSERT INTO eda_flow_node_data (id, node_name, flow_id, type_id, `top`, `left`, remark, " + "params, payload, `from`, `to`, version ) VALUES " + "<foreach collection='list' item='n' separator=','>(" + "#{n.id}, #{n.nodeName}, #{n.flowId}, #{n.typeId}, #{n.top}, #{n.left}, #{n.remark}, " + "#{n.params}, #{n.payload}, #{n.from}, #{n.to}, #{n.version})</foreach></script>")
    public void saveNodeDate(List<NodeData> list);

    @Select("select * from  eda_flow_node_data where flow_id=#{flowId}")
    List<NodeData> findByFlowId(String flowId);

    @Delete("delete from eda_flow_node_data where flow_id=#{flowId}")
    void deleteByFlowId(String flowId);

    @Select("SELECT version  from eda_flow_node_data where flow_id = #{flowId} " +
            "and version is not null group by version order by version desc")
    List<String> findVersionsByFlowId(String flowId);

    @Select("SELECT version  from eda_flow_node_data where flow_id = #{flowId} and version=#{version}")
    List<NodeData> findVersionsByFlowIdAndVersion(String flowId,String version);
}
