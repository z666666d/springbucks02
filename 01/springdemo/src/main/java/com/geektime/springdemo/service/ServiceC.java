package com.geektime.springdemo.service;

import com.geektime.springdemo.component.ComponentA;
import com.geektime.springdemo.component.ComponentB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ServiceC {

    @Autowired
    private ApplicationContext applicationContext;


    /**
     * 通过ApplicationContext获取Bean
     */
    public void test(){
        ComponentA componentA = (ComponentA) applicationContext.getBean("componentA");
        ComponentB componentB = applicationContext.getBean(ComponentB.class);
        componentA.hello();
        componentB.hello();
    }

}
