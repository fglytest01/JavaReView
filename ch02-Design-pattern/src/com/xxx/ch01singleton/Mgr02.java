package com.xxx.ch01singleton;

/**
 * 跟Mgr01是一样的.使用静态语句块进行定义
 */

public class Mgr02 {
    private static final Mgr02 INSTANCE;
    //使用静态语句块进行定义
    static {
        INSTANCE = new Mgr02();
    }

    private Mgr02() {
    };

    public static Mgr02 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] agrs) {
        Mgr02 m1 = Mgr02.getInstance();
        Mgr02 m2 = Mgr02.getInstance();
        System.out.println(m1 == m2);
    }
}
