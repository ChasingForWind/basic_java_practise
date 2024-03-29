package 多线程.JUC包.工具;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrier1 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("======召唤神龙");
        });
        for (int i = 1; i <= 7; i++) {
            final int tempInt = i;
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName() +
                            "\t收集到第" + tempInt + "颗龙珠");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() +
                            "\t第" + tempInt + "颗龙珠飞走了");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "Thread-"+ i).start();
        }
    }
}
