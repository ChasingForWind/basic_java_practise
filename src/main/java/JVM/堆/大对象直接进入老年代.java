package JVM.堆;

/**
 * 测试：大对象直接进入到老年代
 * -Xmx60m -Xms60m -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * -XX:PretenureSizeThreshold = 20m
 *   对象超过多大直接在老年代分配，默认值为0，不限制
 *
 */


public class 大对象直接进入老年代 {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024*1024*10]; //10M
    }
}
