package CompletableFuture的使用.线程编排;/**
 * @Author liuchang
 * @Date 2023/1/18 4:59 PM
 * @Version 1.0
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhiyang
 * @description: thenApply
 * @create: 2023-01-18 16:59
 **/


public class ThenApply {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> people = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "zhiyang";
        });

        CompletableFuture<String> greetingFuture = people
                .thenApply(name -> "hello " + name)
                .thenApply(greeting -> greeting + " Welcome to my house !");

        System.out.println(greetingFuture.get());
    }
}
