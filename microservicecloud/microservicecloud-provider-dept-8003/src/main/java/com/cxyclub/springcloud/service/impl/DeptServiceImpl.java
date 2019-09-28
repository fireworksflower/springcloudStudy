package com.cxyclub.springcloud.service.impl;

import com.cxyclub.springcloud.dao.DeptDao;
import com.cxyclub.springcloud.entities.Dept;
import com.cxyclub.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao dao;
    @Override
    public boolean addDept(Dept dept) {
        return dao.addDept(dept);
    }

    @Override
    public Dept findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Dept> findAll() {
        return dao.findAll();
    }
}
