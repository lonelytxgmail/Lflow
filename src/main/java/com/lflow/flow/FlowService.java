package com.lflow.flow;

import com.github.pagehelper.PageHelper;
import com.lflow.commons.exception.InvalidParameterException;
import com.lflow.commons.http.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Title: FlowService
 * @Package com.lflow.service
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/7 16:44
 */
@Service
public class FlowService {
    final
    FlowMapper flowMapper;

    public FlowService(FlowMapper flowMapper) {
        this.flowMapper = flowMapper;
    }

    public Flow addOne(Flow flow){
        if (flow.getName()==null){
            throw new InvalidParameterException("名称不能为 null");
        }
        Assert.notNull(flow.getName(),"名称为空");
        flow.setStatus(Flow.Status.INIT);
        flow.setCreateDate(new Date());
        flow.setUpdateDate(new Date());
        flowMapper.insert(flow);
        return flow;
    }

    public List<Flow> findList(FlowRequest flowRequest) {
        PageHelper.startPage((PageRequest)flowRequest);
        List<Flow> list = flowMapper.findList(flowRequest);
        return list;
    }

    public String deleteById(String id) {
        flowMapper.deleteById(id);
        return id;
    }

    public void update(Flow flow) {

    }

    public Flow findById(String id) {
        return flowMapper.findById(id);
    }
}
