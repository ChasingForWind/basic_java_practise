package JVM.对象;

import org.openjdk.jol.info.ClassLayout;

public class 空对象的大小 {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println("new Object:" +
                ClassLayout.parseInstance(o).toPrintable());
    }
}
