package com.xxx.ch01单例模式singleton;

/*
 * lazy loading 也称 懒汉式
 * 虽然达到了按需初始化的目的, 但却带来多线程不安全的问题
 */

public class Singleton21 {
    private static Singleton21 INSTANCE;  //不初始化

    private Singleton21() {    //将构造方法设置为private,无法new
    }

    public static Singleton21 getInstance() {   //调用getInstace
        if (INSTANCE == null) {                //判断是否为空
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton21();            //实例化
        }
        return INSTANCE;
    }


    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                System.out.println(Singleton21.getInstance().hashCode());  //打印对象
            }).start();

//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                }
//            })
        }
    }
}
