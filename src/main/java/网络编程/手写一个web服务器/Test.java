package 网络编程.手写一个web服务器;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("src/main/resources/web/geeker.html");
    }
}
