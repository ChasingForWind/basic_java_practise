package CompletableFuture的使用.线程编排;/**
 * @Author liuchang
 * @Date 2023/1/13 5:41 PM
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author: zhiyang
 * @description: 主方法
 * @create: 2023-01-13 17:41
 **/


public class Allof {
    public static void main(String[] args) {
        // 测试allOf接口
        testAllOf();
    }

    /**
     * 返回 1 1+2 1+2+3 1+2+3+4
     */
    private static void testAllOf() {
        // step1 新建futureList
        List<CompletableFuture<Integer>> list = new ArrayList<>();

        // step2 往futureList中塞completableFuture
        for (int i = 1; i <= 10; i++) {
            list.add(getSumFuture(i));
        }

        // step3 转换成数组模式
        CompletableFuture<Integer>[] futuresArray = list.toArray(new CompletableFuture[list.size()]);

        // step4 调用allOf方法
        try {
            CompletableFuture.allOf(futuresArray).get(10, TimeUnit.MINUTES);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // step5 保存结果
        ArrayList<Integer> res = new ArrayList<>(list.size());
        Stream.of(futuresArray).filter(Objects::nonNull).forEach(t->{
            res.add(t.join());
        });

        // step6 展示验证
        Stream.of(res).forEach(System.out::println);
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
