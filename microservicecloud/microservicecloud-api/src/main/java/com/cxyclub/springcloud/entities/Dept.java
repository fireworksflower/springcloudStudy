package com.cxyclub.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {//必须序列化
    private Long deptno;//主键
    private String dname;//部门名称
    private String db_source;//来自那个数据库，因为一个微服务架构可以一个服务对应一个数据库，同一个被存储到不同的数据库

    public Dept(Long deptno) {
        this.deptno = deptno;
    }
}
