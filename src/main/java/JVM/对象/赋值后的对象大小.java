package JVM.对象;

import org.openjdk.jol.info.ClassLayout;

public class 赋值后的对象大小 {
    public static void main(String[] args) {
        Hero a = new Hero();
        System.out.println("new A:" +
                ClassLayout.parseInstance(a).toPrintable());
        a.setFlag(true);
        a.setI(1);
        a.setStr("ABC");
        System.out.println("赋值 A:" +
                ClassLayout.parseInstance(a).toPrintable());
    }

    static class Hero {
        private boolean flag;
        private int i;
        private String str;

        private 空对象的大小 ob;

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public void setI(int i) {
            this.i = i;
        }

        @Override
        public String toString() {
            return "Hero{" +
                    "flag=" + flag +
                    ", i=" + i +
                    ", str='" + str + '\'' +
                    ", ob=" + ob +
                    '}';
        }
    }
}

