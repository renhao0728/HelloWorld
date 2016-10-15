package com.example.citru.helloworld.entity;

import java.io.Serializable;

/**
 * Created by citrus on 2016/8/15.
 */
public class SQliteEntity implements Serializable{
    public int _id;
    public String name;
    public int age;
    public SQliteEntity(){

    }
    public SQliteEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
