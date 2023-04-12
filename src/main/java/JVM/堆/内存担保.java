package JVM.堆;

/*
-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
 */

public class 内存担保 {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        memoryAllocation();
    }
    public static void memoryAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[1 * _1MB];//1M
        allocation2 = new byte[1 * _1MB];//1M
        allocation3 = new byte[1 * _1MB];//1M
        allocation4 = new byte[5 * _1MB];//5M
        System.out.println("完毕");
    }
}
