package com.xxx.ch01singleton;

/*
 静态内部类的方式  : 完美单例 之一
 JVM保证单例: JVM加载类只加载一次, 所以静态内部类Mgr04Holder只能加载一次.
 加载外部类时不会加载内部类, 这样可以实现懒加载
 */

public class Mgr04 {
    private Mgr04() {
    }

    private static class Mgr04Holder {
        private final static Mgr04 INSTANCE = new Mgr04();
    }

    public static Mgr04 getInstance(){
        return Mgr04Holder.INSTANCE;
    }

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
