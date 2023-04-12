package 多线程.原有特性;

public class 验证可见性问题 {

    public static JmmDemo demo = new JmmDemo();


    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(demo);
        t.start();
        Thread.sleep(100);
        demo.flag = false;
        System.out.println("已经修改为false");
        System.out.println(demo.flag);


        // 这个线程一直轮询主内存中的值是否发生改变
        CheckMainCache checkMainCache = new CheckMainCache();
        Thread t2 = new Thread(checkMainCache);
        t2.start();
    }

    static class JmmDemo implements Runnable {
        public boolean flag = true;
        public void run() {
            System.out.println("子线程执行。。。");
            while (flag) {
//                synchronized (this){}
            }
            System.out.println("子线程结束。。。");
        }
    }

    static class CheckMainCache implements Runnable{

        @Override
        public void run() {
            while (true){
                System.out.println("当前读取到主内存的值为:"+demo.flag);
            }
        }
    }
}
