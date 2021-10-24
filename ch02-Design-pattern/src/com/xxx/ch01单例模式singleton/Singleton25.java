package com.xxx.ch01单例模式singleton;

/*
 * lazy loading  * 也称 懒汉式
 * 虽然达到了按需初始化的目的, 但却带来多线程不安全的问题
 * 可以通过synchronized解决, 但也带来了效率下降
 * 双判断检查  **加了双判断就没有问题了????**
 *  ==================================
 *  Java指令中创建对象和赋值操作是分开进行的
 *  INSTANCE = new Mgr03_4();  分两步完成
   1. A、B线程同时进入了第一个if判断
   2. A首先进入synchronized块，由于INSTANCE为null，所以它执行INSTANCE = new Mgr03_4();
   3. 由于JVM内部的优化机制，JVM先画出了一些分配给Singleton实例的空白内存，并赋值给instance成员（注意此时JVM没有开始初始化这个实例），然后A离开了synchronized块。
   4. B进入synchronized块，由于 INSTANCE 此时不是null，因此它马上离开了synchronized块并将结果返回给调用该方法的程序。
   5. 此时B线程打算使用Mgr03_4实例，却发现它没有被初始化，于是错误发生了。
 *  ==================================
 * 解决方法: volatile修饰 Mgr03_4 INSTANCE
 * 通过volatile修饰的变量，不会被线程本地缓存，所有线程对该对象的读写都会第一时间同步到主内存，从而保证多个线程间该对象的准确性
 *
 * volatile的作用:
 * 1. 防止指令重排序，因为instance = new Singleton()不是原子操作
 * 2. 保证内存可见
 * 缺点:
 * 由于volatile关键字可能会屏蔽掉虚拟机中一些必要的代码优化，所以运行效率并不是很高，
 */

public class Singleton25 {
    private volatile static Singleton25 INSTANCE;

    private Singleton25() {
    }

    public static Singleton25 getInstance() {
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if (INSTANCE == null) {
            //同步块，线程安全的创建实例
            synchronized(Singleton25.class){
                //再次检查实例是否存在，如果不存在才真正的创建实例
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton25();
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
                System.out.println(Singleton25.getInstance().hashCode());  //打印对象
            }).start();
        }
    }
}
