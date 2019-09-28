package com.cxyclub.springcloud.service;

import com.cxyclub.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
