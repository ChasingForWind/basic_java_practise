package 多线程.CompletableFuture的使用;/**
 * @Author liuchang
 * @Date 2023/1/16 10:45 AM
 * @Version 1.0
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhiyang
 * @description:
 * @create: 2023-01-16 10:45
 **/


public class Complete {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "success";
        });
        boolean flag = future.complete("hello world");
        if (flag) {
            System.out.println("Future moved to complete state with value - " + future.get());
        } else {
            System.out.println("Future not moved to complete state");
        }
    }
}
