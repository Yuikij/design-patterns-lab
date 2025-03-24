package org.kubo.behavioral;

import java.util.ArrayList;
import java.util.List;
// 观察者模式
public class ObserverDemo {

    // 观察者接口
    public interface Observer {
        void update(String message);
    }

    // 主题接口
    public interface Subject {
        void addObserver(Observer observer);
        void removeObserver(Observer observer);
        void notifyObservers(String message);
    }

// 具体主题，负责维护观察者列表并在状态变化时通知它们

    public static class ConcreteSubject implements Subject {
        private List<Observer> observers = new ArrayList<>();

        // 添加观察者
        @Override
        public void addObserver(Observer observer) {
            observers.add(observer);
        }

        // 移除观察者
        @Override
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        // 通知所有观察者
        @Override
        public void notifyObservers(String message) {
            for (Observer observer : observers) {
                observer.update(message);
            }
        }

        // 模拟状态变化的方法
        public void changeState(String state) {
            System.out.println("Subject state changed to: " + state);
            notifyObservers(state);
        }
    }

    // 具体观察者A
    public static class ConcreteObserverA implements Observer {
        @Override
        public void update(String message) {
            System.out.println("ConcreteObserverA received update: " + message);
        }
    }

    // 具体观察者B
    public static class ConcreteObserverB implements Observer {
        @Override
        public void update(String message) {
            System.out.println("ConcreteObserverB received update: " + message);
        }
    }


        public static void main(String[] args) {
            // 创建主题对象
            ConcreteSubject subject = new ConcreteSubject();

            // 创建观察者对象
            Observer observerA = new ConcreteObserverA();
            Observer observerB = new ConcreteObserverB();

            // 将观察者注册到主题上
            subject.addObserver(observerA);
            subject.addObserver(observerB);

            // 模拟主题状态变化，并通知所有观察者
            subject.changeState("State 1");
            subject.changeState("State 2");
        }


}
