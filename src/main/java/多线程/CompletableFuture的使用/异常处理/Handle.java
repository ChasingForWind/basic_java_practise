package 多线程.CompletableFuture的使用.异常处理;/**
 * @Author liuchang
 * @Date 2023/1/19 10:27 AM
 * @Version 1.0
 */

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: zhiyang
 * @description: Handle
 * @create: 2023-01-19 10:27
 **/


public class Handle {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random random = new Random();
        int age = random.nextInt(150);

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (age < 0) {
                throw new IllegalArgumentException("Age can not be negative!!");
            }

            if (age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).handle((res,ex) -> {
            if (ex != null){
                return "some bad thing happened";
            }
            return res;
        });

        System.out.println(future.get());
    }
}
