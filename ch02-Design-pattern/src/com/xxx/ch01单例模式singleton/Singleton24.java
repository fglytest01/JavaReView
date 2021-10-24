package com.xxx.ch01单例模式singleton;

/*
 * lazy loading  * 也称 懒汉式
 * 虽然达到了按需初始化的目的, 但却带来多线程不安全的问题
 * 可以通过synchronized解决, 但也带来了效率下降
 * ** 双判断检查  **
 */

public class Singleton24 {
    private static Singleton24 INSTANCE;

    private Singleton24() {
    }

    public static Singleton24 getInstance() {
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if (INSTANCE == null) {
            //同步块，线程安全的创建实例
            synchronized(Singleton24.class){
                //再次检查实例是否存在，如果不存在才真正的创建实例
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton24();
                }
            }
        }
        return INSTANCE;
    }


    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                System.out.println(Singleton24.getInstance().hashCode());  //打印对象
            }).start();
        }
    }
}
