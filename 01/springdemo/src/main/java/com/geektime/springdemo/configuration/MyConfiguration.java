package com.geektime.springdemo.configuration;

import com.geektime.springdemo.component.ComponentB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public ComponentB componentB(){
        return new ComponentB();
    }

}
