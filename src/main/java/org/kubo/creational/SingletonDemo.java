package org.kubo.creational;
// 单例模式
public class SingletonDemo {
    private static volatile SingletonDemo instance;

    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("do something");
    }
}
