package com.xxx.ch01singleton;

/**
 * lazy loading 也称 懒汉式
 * 虽然达到了按需初始化的目的, 但却带来多线程不安全的问题
 */

public class Mgr03 {
    private static Mgr03 INSTANCE;  //不初始化

    private Mgr03() {    //将构造方法设置为private,无法new
    }

    public static Mgr03 getInstance() {   //调用getInstace
        if (INSTANCE == null) {                //判断是否为空
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();            //实例化
        }
        return INSTANCE;
    }


    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                System.out.println(Mgr03.getInstance().hashCode());  //打印对象
            }).start();

//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                }
//            })
        }
    }
}
