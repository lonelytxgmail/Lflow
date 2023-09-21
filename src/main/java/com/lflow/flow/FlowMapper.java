package com.lflow.flow;

import com.lflow.flow.Flow;
import com.lflow.flow.FlowRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description:
 * @Title: FlowMapper
 * @Package com.lflow.mapper
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/7 15:16
 */
@Mapper
public interface FlowMapper {
    @Insert("insert into `eda_flow` (id, name, description, username, status, create_date, update_date) values " +
            "(#{id},#{name},#{description},#{username},#{status},#{createDate},#{updateDate})")
    void insert(Flow flow);

    @Select("<script>" +
            "select * from eda_flow  where 1=1 " +
            "<if test='name!=null'>and `name`=#{name}</if> " +
            "<if test='status!=null'>and `status`=#{status}</if> " +
            "order by create_date" +
            "</script>")
    List<Flow> findList(FlowRequest flowRequest);

    @Select("select * from eda_flow where  id=#{id}")
    Flow findById(String id);

    @Update("update `eda_flow` set `name`=#{name},`description`=#{description},`update_date`=#{updateDate} where id = #{id}")
    void update(Flow flow);

    @Delete("delete from eda_flow where  id =#{id}")
    void deleteById(String id);
}
