package 多线程.CompletableFuture的使用.线程编排;/**
 * @Author liuchang
 * @Date 2023/1/18 5:21 PM
 * @Version 1.0
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhiyang
 * @description: ThenApplyAsync
 * @create: 2023-01-18 17:21
 **/


public class ThenApplyAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("异步1当前线程为"+Thread.currentThread().getName());
            return "zhiyang";
        }).thenApplyAsync(result -> {
            System.out.println("异步2当前线程为"+Thread.currentThread().getName());
            return "complete 2 ...." + result;
        }, Executors.newFixedThreadPool(1));

        System.out.println("主线程线程为"+Thread.currentThread().getName());
        System.out.println(future.get());
    }
}
