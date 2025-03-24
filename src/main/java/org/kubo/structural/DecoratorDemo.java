package org.kubo.structural;

// 装饰器模式
public class DecoratorDemo {

    // 抽象组件
    interface Component {
        void operation();
    }

    // 具体组件
    static class ConcreteComponent implements Component {
        @Override
        public void operation() {
            System.out.println("执行具体组件的操作");
        }
    }

    // 抽象组件
    static class Decorator {
        Component component;

        Decorator(Component component) {
            this.component = component;
        }

        public void operation() {
            component.operation();
        }

    }

    static class ConcreteDecoratorA extends Decorator {
        ConcreteDecoratorA(Component component) {
            super(component);
        }

        @Override
        public void operation() {
            component.operation();
            doOtherThing();
        }

        private void doOtherThing() {
            System.out.println("执行增强操作");
        }

    }

    public static void main(String[] args) {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA(concreteComponent);
        concreteDecoratorA.operation();
    }

}
