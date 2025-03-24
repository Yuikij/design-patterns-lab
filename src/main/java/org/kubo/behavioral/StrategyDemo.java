package org.kubo.behavioral;

// 策略模式
public class StrategyDemo {
// 策略接口
    interface Pay {
        void pay();
    }
// 具体策略类
    static class AliPay implements Pay{

        @Override
        public void pay() {
            System.out.println("支付宝支付");
        }
    }


    static class WxPay implements Pay{

        @Override
        public void pay() {
            System.out.println("微信支付");
        }
    }

// 上下文类
    static class PaymentContext {
        private Pay paymentStrategy;

        public void setPaymentStrategy(Pay paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void executePayment() {
            paymentStrategy.pay();
        }
    }

    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();
        paymentContext.setPaymentStrategy(new AliPay());
        paymentContext.executePayment();
    }

}
