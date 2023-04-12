package 多线程.原有特性;

import java.util.concurrent.atomic.AtomicInteger;

public class Volatile的缺陷 {
    public static void main(String[] args) throws InterruptedException {
        VolatileDemo demo = new VolatileDemo();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(demo);
            t.start();
        }
        Thread.sleep(1000);
        System.out.println("count = " + demo.count);
    }

    static class VolatileDemo implements Runnable {
        public volatile AtomicInteger count = new AtomicInteger();

        //public volatile AtomicInteger count = new AtomicInteger(0);
        public void run() {
            addCount();
        }

        public void addCount() {
            for (int i = 0; i < 10000; i++) {
                // count++;//但是实际情况是三条汇编指令
                count.incrementAndGet();
            }
        }
    }
}
