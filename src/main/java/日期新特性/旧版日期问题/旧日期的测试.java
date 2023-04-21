package 日期新特性.旧版日期问题;/**
 * @Author liuchang
 * @Date 2023/2/27 5:48 PM
 * @Version 1.0
 */

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author: zhiyang
 * @description: 旧日期的测试
 * @create: 2023-02-27 17:48
 **/


public class 旧日期的测试 {
    public static void main(String[] args) {
        Date date = new Date(2023-1900, 2, 1, 11, 12, 13);
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println(date);




        // 将java.util.Date转换为java.time.LocalDateTime
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        System.out.println("java.util.Date : " + date);
        System.out.println("java.time.LocalDateTime : " + localDateTime);
    }
}
