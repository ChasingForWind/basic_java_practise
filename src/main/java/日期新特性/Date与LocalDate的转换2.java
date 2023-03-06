package 日期新特性;

import java.sql.Date;
import java.sql.Timestamp;

public class Date与LocalDate的转换2 {
    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis());
        System.out.println("转换前的类："+date);
        System.out.println("转换后的类："+ date.toLocalDate());

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("转换前的类："+timestamp);
        System.out.println("转换后的类："+ timestamp.toLocalDateTime());

    }
}
