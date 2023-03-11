package 多线程.CompletableFuture的使用.创建异步线程;/**
 * @Author liuchang
 * @Date 2023/1/16 11:07 AM
 * @Version 1.0
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhiyang
 * @description: 测试runAsync
 * @create: 2023-01-16 11:07
 **/


public class RunAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("休息1秒之后显示");
        });
        completableFuture.get();
    }
}
