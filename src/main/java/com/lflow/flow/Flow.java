package com.lflow.flow;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Flow {
    private String id;
    private String name;
    private String description;
    private String username;
    private Status status;
    @JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分ss秒",timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分ss秒",timezone = "GMT+8")
    private Date updateDate;

    public enum Status {
        /**
         * 未运行
         */
        INIT,
        /**
         * 运行中
         */
        RUNNING,
        /**
         * 运行完成
         */
        FINISHED,
        /**
         * 运行失败
         */
        FAILED
    }
}
