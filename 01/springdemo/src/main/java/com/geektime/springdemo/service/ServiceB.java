package com.geektime.springdemo.service;

import com.geektime.springdemo.component.ComponentA;
import com.geektime.springdemo.component.ComponentB;

/**
 * 通过XML进行Bean装配
 */
public class ServiceB {


    private ComponentA componentA;

    private ComponentB componentB;

    private String valueA;

    private String valueB;

    public ServiceB(ComponentA componentA,String valueA){
        this.componentA = componentA;
        this.valueA = valueA;
    }

    public void setComponentB(ComponentB componentB) {
        this.componentB = componentB;
    }

    public void setValueB(String valueB) {
        this.valueB = valueB;
    }

    public void test(){
        componentA.hello();
        componentB.hello();
        System.out.println(valueA);
        System.out.println(valueB);
    }
}
