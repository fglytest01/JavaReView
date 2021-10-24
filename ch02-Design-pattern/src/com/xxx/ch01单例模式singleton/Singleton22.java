package com.xxx.ch01单例模式singleton;

/**
 * lazy loading  * 也称 懒汉式
 * 虽然达到了按需初始化的目的, 但却带来多线程不安全的问题
 * * * 可以通过synchronized解决, 但也带来了效率下降
 */

public class Singleton22 {
    private static Singleton22 INSTANCE;

    private Singleton22() {
    }

    public static synchronized Singleton22 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton22();
        }
        return INSTANCE;
    }


    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                System.out.println(Singleton22.getInstance().hashCode());  //打印对象
            }).start();
        }
    }
}
