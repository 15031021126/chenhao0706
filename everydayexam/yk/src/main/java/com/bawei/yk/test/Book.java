package com.bawei.yk.test;

/*
 *@Auther:陈浩
 *@Date: 2019/7/27
 *@Time:15:38
 *@Description:${DESCRIPTION}
 * */public class Book {
    public String name;
    private int price;

    public Book(String name) {
        this.name = name;
    }
    private Book() {
    }
    private void fun(){
        System.out.println("这是私有的无参方法");
    }
    private void fun(String name){
        System.out.println("这是私有的有参方法"+name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}