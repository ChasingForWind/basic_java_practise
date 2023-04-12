package 多线程.JUC包.线程池;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor的使用 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        
        for (int i = 0; i < 10; i++) {
            executorService.submit(()->{
                System.out.println("hello");
            });
        }

        executorService.shutdown();
        if (executorService.isShutdown()){
            System.out.println("线程执行完毕");
        }
    }
}
