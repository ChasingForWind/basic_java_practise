package 多线程.JUC包.锁;

import java.util.concurrent.locks.ReentrantLock;

public class 简单的可重入锁 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        lock.lock();

        //
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        lock.unlock();
    }
}
