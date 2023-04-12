package 多线程.JUC包.工具;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Semaphore1 {
    public static void main(String[] args) {
        //模拟资源类，有3个空车位
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                try{
                    //占有资源
                    semaphore.acquire();
                    Random random = new Random();
                    System.out.println(Thread.currentThread().getName()+"\t 抢到车位");
                    int time = random.nextInt(10);
                    try { TimeUnit.SECONDS.sleep(time); } catch
                    (InterruptedException e) {e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName()+"\t 停车"+time+"秒后离开车位");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //释放资源
                    semaphore.release();
                }
            }, "Thread-Car-"+String.valueOf(i)).start();
        }
    }
}
