package com.geektime.springdemo02.Controller;

import com.geektime.springdemo02.model.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/json",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Person getJson(){
        Person person = new Person();
        person.setName("张三");
        person.setAge(20);
        person.setSex("男");
        person.setAddress("中国");

        return person;
    }


    @GetMapping(value = "/xml",produces = MediaType.APPLICATION_XML_VALUE)
    public Person getXml(){
        Person person = new Person();
        person.setName("张三");
        person.setAge(20);
        person.setSex("男");
        person.setAddress("中国");

        return person;
    }


}
