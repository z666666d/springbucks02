package com.geektime.springdemo;

import com.geektime.springdemo.service.ServiceA;
import com.geektime.springdemo.service.ServiceB;
import com.geektime.springdemo.service.ServiceC;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringdemoApplication.class)
public class SpringdemoApplicationTests {

    @Autowired
    private ServiceA serviceA;

    @Autowired
    private ServiceB serviceB;

    @Autowired
    private ServiceC serviceC;

    @Test
    public void test() {
        serviceA.test();
        serviceB.test();
        serviceC.test();
    }

}
