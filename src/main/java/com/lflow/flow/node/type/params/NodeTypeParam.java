package com.lflow.flow.node.type.params;

import lombok.Data;

/**
 * @Description:
 * @Title: NodeTypeParams
 * @Package com.lflow.flow.node.type.params
 * @Author: Lee YiFan
 * @CreateTime: 2023/9/19 19:53
 */
@Data
public class NodeTypeParam {
    private Integer id;
    private Integer typeId;
    private String key;
    private String name;
    private boolean required;
    /** 参数输入类型: input | select */
    private String inType = "input";
    /** 下拉选项内容，多个值以逗号分隔 */
    private String option;
    /** 参数值提示性内容 */
    private String placeholder;

}
