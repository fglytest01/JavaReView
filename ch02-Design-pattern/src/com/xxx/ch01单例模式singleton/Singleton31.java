package com.xxx.ch01单例模式singleton;

/*
 * 饿汉式:
通过静态 * 内部 * 类
JVM保证单例: JVM加载类只加载一次, 所以静态内部类Mgr04Holder只能加载一次.
当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕
同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题。这样我们暂时总结一个完美的单例模式。
 */

public class Singleton31 {
    /* 私有的构造方法, 防止被实例化 */
    private Singleton31() {
    };


    /* 定义静态内部类 */
    private static class SingletonFactory {
        private static Singleton31 INSTANCE = new Singleton31();
    }


    /* 获取实例 唯一对外开发 */
    public static Singleton31 getInstance() {
        return SingletonFactory.INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] agrs) {
        Singleton31 m1 = Singleton31.getInstance();
        Singleton31 m2 = Singleton31.getInstance();
        System.out.println(m1 == m2);
    }
}
