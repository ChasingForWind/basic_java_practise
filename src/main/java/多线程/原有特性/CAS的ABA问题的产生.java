package 多线程.原有特性;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CAS的ABA问题的产生 {
    static AtomicInteger ar = new AtomicInteger(100);


    public static void main(String[] args) throws InterruptedException {
        System.out.println("======ABA问题的产生======");

        Thread t1 = new Thread(() -> {
            ar.compareAndSet(100, 101);
            ar.compareAndSet(101, 100);
        }, "t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ar.compareAndSet(100, 2022) + "\t" +
                    ar.get());
        }, "t2");
        t2.start();

//顺序执行，AtomicInteger案例先执行
        t1.join();
        t2.join();
    }
}

