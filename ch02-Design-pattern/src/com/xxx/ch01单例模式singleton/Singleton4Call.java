package com.xxx.ch01单例模式singleton;

/**
 * 枚举单例: 最完美单例
 * 不仅可以解决线程同步, 还可以防止反序列化
 * 一行就代表了一个实例.
 */

public class Singleton4Call {
    public static void main(String[] args) {
        int Singleton1 = Singleton41.INSTANCE.hashCode();
        int Singleton2 = Singleton41.INSTANCE.hashCode();
        System.out.println(Singleton1 == Singleton2);
    }
}


