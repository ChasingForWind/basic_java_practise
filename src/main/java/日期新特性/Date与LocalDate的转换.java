package 日期新特性;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class Date与LocalDate的转换 {
    public static void main(String[] args) {

        // 方式一
        Date date = new Date();
        Instant instant = date.toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        LocalDate localDate = zonedDateTime.toLocalDate();
        System.out.println("转换前的类："+ date);
        System.out.println("转换后的类："+localDate);
    }
}
