package CompletableFuture的使用.线程编排;/**
 * @Author liuchang
 * @Date 2023/1/18 5:16 PM
 * @Version 1.0
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhiyang
 * @description:
 * @create: 2023-01-18 17:16
 **/


public class ThenRun {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("stage1 finish...");
        }).thenRun(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("stage2 finish...");
        }).get();
    }
}
