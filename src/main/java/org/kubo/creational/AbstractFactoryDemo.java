package org.kubo.creational;
// 抽象工厂模式
// 由产品和工厂组成
public class AbstractFactoryDemo {

    // 抽象产品接口 - 按钮
    interface Button {
        void display();
    }

    // 具体产品类 - Windows 按钮
    static class WindowsButton implements Button {
        @Override
        public void display() {
            System.out.println("显示 Windows 样式的按钮");
        }
    }

    // 具体产品类 - macOS 按钮
    static class MacOSButton implements Button {
        @Override
        public void display() {
            System.out.println("显示 macOS 样式的按钮");
        }
    }

    // 抽象产品接口 - 文本框
    interface TextBox {
        void show();
    }

    // 具体产品类 - Windows 文本框
    static class WindowsTextBox implements TextBox {
        @Override
        public void show() {
            System.out.println("显示 Windows 样式的文本框");
        }
    }

    // 具体产品类 - macOS 文本框
    static class MacOSTextBox implements TextBox {
        @Override
        public void show() {
            System.out.println("显示 macOS 样式的文本框");
        }
    }

    // 抽象工厂接口
    interface UIFactory {
        Button createButton();
        TextBox createTextBox();
    }

    // 具体工厂类 - Windows 工厂
    static class WindowsFactory implements UIFactory {
        @Override
        public Button createButton() {
            return new WindowsButton();
        }
        @Override
        public TextBox createTextBox() {
            return new WindowsTextBox();
        }
    }

    // 具体工厂类 - macOS 工厂
    static class MacOSFactory implements UIFactory {
        @Override
        public Button createButton() {
            return new MacOSButton();
        }
        @Override
        public TextBox createTextBox() {
            return new MacOSTextBox();
        }
    }

    public static void main(String[] args) {
        // 使用 Windows 工厂创建一组相关的 UI 元素
        UIFactory windowsFactory = new WindowsFactory();
        Button windowsButton = windowsFactory.createButton();
        TextBox windowsTextBox = windowsFactory.createTextBox();
        windowsButton.display();
        windowsTextBox.show();

        System.out.println("--------------------");

        // 使用 macOS 工厂创建一组相关的 UI 元素
        UIFactory macosFactory = new MacOSFactory();
        Button macosButton = macosFactory.createButton();
        TextBox macosTextBox = macosFactory.createTextBox();
        macosButton.display();
        macosTextBox.show();
    }

}
