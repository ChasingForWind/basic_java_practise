package CompletableFuture的使用.异常处理;/**
 * @Author liuchang
 * @Date 2023/1/19 10:23 AM
 * @Version 1.0
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: zhiyang
 * @description: Exceptionally
 * @create: 2023-01-19 10:23
 **/


public class Exceptionally {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Integer age = -1;

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (age < 0) {
                throw new IllegalArgumentException("Age can not be negative!!");
            }

            if (age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).exceptionally(ex -> {
            System.out.println("some bad thing happened");
            return "false";
        });
        System.out.println(future.get());
    }
}
