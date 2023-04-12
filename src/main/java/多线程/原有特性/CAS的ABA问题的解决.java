package 多线程.原有特性;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CAS的ABA问题的解决 {
    static AtomicStampedReference<Integer> asr = new
            AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        System.out.println("======ABA问题的解决======");
        new Thread(() -> {
            int stamp = asr.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t第一次版 本号： " + stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException
                    e) {
                e.printStackTrace();
            }
            asr.compareAndSet(100, 101, asr.getStamp(), asr.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t第二次版 本号： " + asr.getStamp());
            asr.compareAndSet(101, 100, asr.getStamp(), asr.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t第三次版 本号： " + asr.getStamp());
        }, "t3").start();

        new Thread(() -> {
            int stamp = asr.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t第一次版 本号： " + stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException
                    e) {
                e.printStackTrace();
            }
            boolean result = asr.compareAndSet(100, 2022, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + "\t修改成功与 否：" + result + " 当前最新版本号" + asr.getStamp());
            System.out.println(Thread.currentThread().getName() + "\t当前实际 值：" + asr.getReference());
        }, "t4").start();
    }
}
