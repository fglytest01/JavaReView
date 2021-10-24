package com.xxx.ch01单例模式singleton;

/*
 * 饿汉式:  类加载到内存后, 就实例化一个单例, JVM保证线程安全
 * 简单实用, 推荐使用!
 * 唯一缺点: 不管用到与否, 类装载时就完成实例化
 * (话说你不用的,你装载他干嘛)
 */

public class Singleton11 {
    private static final Singleton11 INSTANCE = new Singleton11();

    private Singleton11() {
    };

    public static Singleton11 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] agrs) {
        Singleton11 m1 = Singleton11.getInstance();
        Singleton11 m2 = Singleton11.getInstance();
        System.out.println(m1 == m2);
    }


}
