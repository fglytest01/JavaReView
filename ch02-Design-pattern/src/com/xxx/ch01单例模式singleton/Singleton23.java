package com.xxx.ch01单例模式singleton;

/**
 * lazy loading  * 也称 懒汉式
 * 虽然达到了按需初始化的目的, 但却带来多线程不安全的问题
 * 可以通过synchronized解决, 但也带来了效率下降
 * ** 视图通过减少同步代码块的方式提高效率, 然后不可行 Fail**
 */

public class Singleton23 {
    private static Singleton23 INSTANCE;

    private Singleton23() {
    }

    public static Singleton23 getInstance() {
        if (INSTANCE == null) {
            //视图通过减少同步代码块的方式提高效率, 然后不可行
            synchronized(Singleton23.class){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Singleton23();
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
                System.out.println(Singleton23.getInstance().hashCode());  //打印对象
            }).start();
        }
    }
}
