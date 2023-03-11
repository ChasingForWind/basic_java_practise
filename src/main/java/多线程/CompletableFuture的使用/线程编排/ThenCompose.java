package 多线程.CompletableFuture的使用.线程编排;/**
 * @Author liuchang
 * @Date 2023/1/18 5:28 PM
 * @Version 1.0
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: zhiyang
 * @description: thenCompose
 * @create: 2023-01-18 17:28
 **/


public class ThenCompose {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThenCompose test = new ThenCompose();
        System.out.println(test.getName().thenCompose(test::sayHello).get());

        // 区别在哪里
        System.out.println(CompletableFuture.supplyAsync(() -> "zhiyang").thenApply(name -> "hello " + name).get());
    }

    CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(()-> "zhiyang");
    }

    CompletableFuture<String> sayHello(String name){
        return CompletableFuture.supplyAsync(()-> "hello " + name);
    }
}
