package com.xxx.ch01singleton;

/**
 *  枚举单例: 完美单例
 * 不仅可以解决线程同步, 还可以防止反序列化
 */

public enum  Mgr05 {
    INSTANCE;

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                System.out.println(Mgr04.getInstance().hashCode());  //打印对象
            }).start();
        }
    }
}
