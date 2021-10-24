package com.xxx.ch01单例模式singleton;

/*
 * 饿汉式: 跟 Singleton11 是一样的.使用静态语句块进行定义
 */

public class Singleton12 {
    private static final Singleton12 INSTANCE;
    //使用静态语句块进行定义
    static {
        INSTANCE = new Singleton12();
    }

    private Singleton12() {
    };

    public static Singleton12 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] agrs) {
        Singleton12 m1 = Singleton12.getInstance();
        Singleton12 m2 = Singleton12.getInstance();
        System.out.println(m1 == m2);
    }
}
