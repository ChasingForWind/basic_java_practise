package 多线程.CompletableFuture的使用.线程编排;/**
 * @Author liuchang
 * @Date 2023/1/18 5:09 PM
 * @Version 1.0
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhiyang
 * @description: ThenAccept
 * @create: 2023-01-18 17:09
 **/


public class ThenAccept {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "zhiyang";
        }).thenAccept(name -> {
            System.out.println("My name is " + name);
        });
        future.get();
    }
}
