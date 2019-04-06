package com.wsh.springcloud.service.impl;

import com.wsh.springcloud.dao.DeptDao;
import com.wsh.springcloud.entities.Dept;
import com.wsh.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jue
 * @date 2019/3/25 23:38
 * @describe
 */
@Service
public class DeptServiceImpl implements DeptService
{
    @Autowired
    private DeptDao dao ;

    @Override
    public boolean add(Dept dept)
    {
        return dao.addDept(dept);
    }

    @Override
    public Dept get(Long id)
    {
        return dao.findById(id);
    }

    @Override
    public List<Dept> list()
    {
        return dao.findAll();
    }

}
