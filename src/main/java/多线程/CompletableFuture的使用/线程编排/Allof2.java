package 多线程.CompletableFuture的使用.线程编排;/**
 * @Author liuchang
 * @Date 2023/1/18 5:55 PM
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * @author: zhiyang
 * @description: Allof2
 * @create: 2023-01-18 17:55
 **/


public class Allof2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
        CompletableFuture<Integer>[] futureArray = list.stream().map(Allof2::getSumFuture).toArray(CompletableFuture[]::new);

        // 核心代码
        CompletableFuture.allOf(futureArray);

        ArrayList<Integer> res = new ArrayList<>();
        Stream.of(futureArray).forEach(t->{
            res.add(t.join());
        });

        for (Integer re : res) {
            System.out.println(re);
        }

    }


    public static CompletableFuture<Integer> getSumFuture(Integer i){
        return CompletableFuture.supplyAsync(()->{
            System.out.println("线程"+i+"开始运行");
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum+=j;
            }
            return sum;
        });
    }
}
