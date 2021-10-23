package com.xxx.ch01singleton;

/**
 * lazy loading  * 也称 懒汉式
 * 虽然达到了按需初始化的目的, 但却带来多线程不安全的问题
 * 可以通过synchronized解决, 但也带来了效率下降
 * ** 视图通过减少同步代码块的方式提高效率, 然后不可行 Fail**
 */

public class Mgr03_2 {
    private static Mgr03_2 INSTANCE;

    private Mgr03_2() {
    }

    public static Mgr03_2 getInstance() {
        if (INSTANCE == null) {
            //视图通过减少同步代码块的方式提高效率, 然后不可行
            synchronized(Mgr03_2.class){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr03_2();
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
                System.out.println(Mgr03_2.getInstance().hashCode());  //打印对象
            }).start();
        }
    }
}
