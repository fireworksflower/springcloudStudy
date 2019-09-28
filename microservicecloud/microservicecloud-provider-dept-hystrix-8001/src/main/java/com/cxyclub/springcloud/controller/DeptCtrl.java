package com.cxyclub.springcloud.controller;


import com.cxyclub.springcloud.entities.Dept;
import com.cxyclub.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptCtrl {

    @Autowired
    private DeptService service;

    @Autowired
    private DiscoveryClient client;


   /*@RequestMapping("/dept/add")
    public boolean add(@RequestBody Dept dept){
        return service.addDept(dept);
    }*/

    @RequestMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept findById(@PathVariable("id") Long id){
        Dept dept =  service.findById(id);
        if(null == dept)
        {
            throw new RuntimeException("该ID："+id+"没有没有对应的信息");
        }
        return dept;
    }



   /* @RequestMapping("/dept/list")
    public List<Dept> findAll(){
        return service.findAll();
    }

   @RequestMapping(value = "/dept/discovery")
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }*/

    public Dept processHystrix_Get(@PathVariable("id") Long id)
    {
        return new Dept().setDeptno(id)
                .setDname("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }


}
