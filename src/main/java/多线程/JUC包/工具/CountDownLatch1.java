package 多线程.JUC包.工具;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatch1 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                Random random = new Random();
                try { TimeUnit.SECONDS.sleep(random.nextInt(10)); } catch
                (InterruptedException e) {e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + "\t上完班，离开公司");
                        countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        new Thread(()->{
            try {
                countDownLatch.await();//卷王也是有极限的，设置超时时间
                System.out.println(Thread.currentThread().getName()+"\t卷王最 后关灯走人");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "7").start();
    }
}
