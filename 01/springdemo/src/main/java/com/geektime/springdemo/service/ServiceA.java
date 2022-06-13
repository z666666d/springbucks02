package com.geektime.springdemo.service;

import com.geektime.springdemo.component.ComponentA;
import com.geektime.springdemo.component.ComponentB;
import com.geektime.springdemo.component.ComponentC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 通过@Autowired注解进行Bean装配
 */
@Service
public class ServiceA {

    /**
     * 通过@Autowired注解用于属性上实现自动装配
     */
    @Autowired
    private ComponentA componentA;

    private ComponentB componentB;

    private ComponentC componentC;

    /**
     * 通过@Value注解注入基本数据类型和String
     */
    @Value("${service.value}")
    private String value;

    /**
     * 通过@Autowired注解用于构造方法上实现自动装配
     * @param componentC
     */
    @Autowired
    public ServiceA(ComponentC componentC){
        this.componentC = componentC;
    }

    /**
     * 通过@Autowired注解用于setter方法上用于自动装配
     * @param componentB
     */
    @Autowired
    public void setComponentB(ComponentB componentB){
        this.componentB = componentB;
    }


    public void test(){
        componentA.hello();
        componentB.hello();
        componentC.hello();
        System.out.println(value);
    }

}
