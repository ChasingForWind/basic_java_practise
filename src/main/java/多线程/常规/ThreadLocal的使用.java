package 多线程.常规;

public class ThreadLocal的使用 {

    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    public static ThreadLocal<Object> threadLocal1 = new ThreadLocal<>();;



    public static void main(String[] args) {
        threadLocal.set("hello");
        threadLocal1.set("morning");
        b();
    }

    public static void b(){
        System.out.println(threadLocal.get());
        c();
    }

    public static void c(){
        System.out.println(threadLocal1.get());
    }




}
