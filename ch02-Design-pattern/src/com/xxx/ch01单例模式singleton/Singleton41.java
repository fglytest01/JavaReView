package com.xxx.ch01单例模式singleton;

/**
 *  枚举单例: 最完美单例
 * 不仅可以解决线程同步, 还可以防止反序列化
 * 一行就代表了一个实例.
 */

public enum Singleton41 {
    INSTANCE;

    public void m() {
        System.out.println("m");
    }
}


