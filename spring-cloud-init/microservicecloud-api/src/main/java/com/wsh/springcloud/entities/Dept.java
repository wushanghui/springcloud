package com.wsh.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


@NoArgsConstructor //无参构造器
@AllArgsConstructor //全参构造器
@Data //getset方法
@Accessors(chain = true) //链式连接
public class Dept implements Serializable { // entity --orm--- db_table
    /**
     * 主键
     */
    private Long deptno;
    private String dname;
    /**
     * 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
     */
    private String db_source;

    public Dept(String dname) {
        super();
        this.dname = dname;
    }


}
