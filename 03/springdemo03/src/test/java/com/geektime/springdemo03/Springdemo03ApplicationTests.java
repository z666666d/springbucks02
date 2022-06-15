package com.geektime.springdemo03;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springdemo03Application.class)
public class Springdemo03ApplicationTests {

    @Autowired
    private HttpRequestDemo httpRequestDemo;

    @Test
    public void test() throws InterruptedException {

        httpRequestDemo.test1();
        httpRequestDemo.test2();
        httpRequestDemo.test3();
        httpRequestDemo.test4();

        // 等待webClient调用结束再结束主线程
        Thread.sleep(10000);
    }

}
