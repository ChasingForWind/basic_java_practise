package 多线程.原有特性.future相关;

import java.util.concurrent.*;

public class FutureTask创建任务 {
    public static void main(String[] args) {
        Task task = new Task();
        //FutureTask继承Future和Runnalbe接口
        FutureTask<Integer> integerFutureTask = new FutureTask<>(task);
        // new Thread(integerFutureTask).start();
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(integerFutureTask);
        try {
            System.out.println("task运行结果：" + integerFutureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程正在计算");
        Thread.sleep(3000);
        //模拟子线程处理业务逻辑
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}
