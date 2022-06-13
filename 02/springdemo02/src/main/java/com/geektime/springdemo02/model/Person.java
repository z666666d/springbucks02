package com.geektime.springdemo02.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Person {

    private String name;

    private int age;

    private String sex;

    private String address;
}
