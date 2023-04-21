package 日期新特性;/**
 * @Author liuchang
 * @Date 2023/3/3 3:13 PM
 * @Version 1.0
 */

import java.time.ZoneId;

/**
 * @author: zhiyang
 * @description: JVM时区和系统时区
 * @create: 2023-03-03 15:13
 **/


public class JVM时区和系统时区 {
    public static void main(String[] args) {
        System.out.println(ZoneId.systemDefault());
    }
}
