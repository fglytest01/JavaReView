package com.xxx.ch01singleton;

/*
 * lazy loading  * 也称 懒汉式
 * 虽然达到了按需初始化的目的, 但却带来多线程不安全的问题
 * 可以通过synchronized解决, 但也带来了效率下降
 * ** 双判断检查   OK **
 */

public class Mgr03_3 {
    private static Mgr03_3 INSTANCE;

    private Mgr03_3() {
    }

    public static Mgr03_3 getInstance() {
        if (INSTANCE == null) {
            //双判断检查
            synchronized(Mgr03_3.class){
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr03_3();
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
                System.out.println(Mgr03_3.getInstance().hashCode());  //打印对象
            }).start();
        }
    }
}
