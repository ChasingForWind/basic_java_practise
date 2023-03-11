package 多线程.CompletableFuture的使用.创建异步线程;/**
 * @Author liuchang
 * @Date 2023/1/16 11:17 AM
 * @Version 1.0
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhiyang
 * @description: 测试supplyAsync
 * @create: 2023-01-16 11:17
 **/


public class SupplyAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "休息1秒之后显示";
        });
        System.out.println(completableFuture.get());
    }
}
