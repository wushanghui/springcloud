package com.wsh.springcloud.service;

import com.wsh.springcloud.entities.Dept;

import java.util.List;

/**
 * @author jue
 * @date 2019/3/25 23:37
 * @describe
 */
public interface DeptService {

    public boolean add(Dept dept);
    public Dept    get(Long id);
    public List<Dept> list();

}
