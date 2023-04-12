package 多线程.原有特性;


public class Synchronize的信号量的唤醒 {
    public static void main(String[] args) {
        BarberShop barberShop = new BarberShop();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                barberShop.wash();
            }
        }, "tony-雄雄").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                barberShop.cut();
            }
        }, "tony-超超").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                barberShop.cook();
            }
        }, "tony-麦麦").start();
    }
}

class BarberShop {
    private volatile int number = 1; //tony-雄雄:1, tony-超超:2, tony-麦麦:3

    /**
     * A线程每一轮要执行的操作
     */
    public void wash() {
        synchronized (this){
            try {
                //判断
                while (number != 1) {
                    wait();
                }
                //模拟线程执行的任务
                System.out.println(Thread.currentThread().getName() + "-洗头");
                //通知
                number = 2;
                notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * B线程每一轮要执行的操作
     */
    public void cut() {
        synchronized (this) {
            try {
                //判断
                while (number != 2) {
                   wait();
                }
                //模拟线程执行的任务
                System.out.println(Thread.currentThread().getName() + "-理发");
                //通知
                number = 3;
                notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cook() {
        synchronized (this) {
            try {
                //判断
                while (number != 3) {
                    wait();
                }
                //模拟线程执行的任务
                System.out.println(Thread.currentThread().getName() + "-吹干");
                //通知
                number = 1;
                notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

