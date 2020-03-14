package com.pu.reflection;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/3/14 23:54
 */
public class User {
    private String name;

    public User() {
        this.name = "pubojian";
    }

    public User(String name){
        this.name = name;
    }

    public void publicMethod(String s){
        System.out.println(name + " love " + s);
    }

    private void privateMethod(){
        System.out.println(name + " love " + name);
    }
}
