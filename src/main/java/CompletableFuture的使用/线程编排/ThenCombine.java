package CompletableFuture的使用.线程编排;/**
 * @Author liuchang
 * @Date 2023/1/18 5:44 PM
 * @Version 1.0
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhiyang
 * @description: thenCombine
 * @create: 2023-01-18 17:44
 **/


public class ThenCombine {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> res1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 100;
        });

        CompletableFuture<Integer> res2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 20;
        });

        System.out.println(res1.thenCombine(res2, (n1, n2) -> n1 / n2).get());
    }
}
