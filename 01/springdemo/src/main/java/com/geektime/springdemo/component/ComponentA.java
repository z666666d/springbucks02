package com.geektime.springdemo.component;

import org.springframework.stereotype.Component;

/**
 * ComponentA使用@Component注解创建Bean
 */
@Component
public class ComponentA {

    public void hello(){
        System.out.println("Hello ComponentA!");
    }
}
