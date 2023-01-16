package 日期新特性;

import java.time.*;

public class 获取特定时间 {
    public static void main(String[] args) {
        // 当前时间
        System.out.println("Instant:"+ Instant.now());
        System.out.println("LocateDate:"+ LocalDate.now());
        System.out.println("LocalTime:"+ LocalTime.now());
        System.out.println("LocalDateTime:"+ LocalDateTime.now());
        System.out.println("ZoneDateTime"+ ZonedDateTime.now());

        // 精确时间
        System.out.println("年："+ Year.now());
        System.out.println("年月："+YearMonth.now());
        System.out.println("月日："+MonthDay.now());

        // 自定义时间
        System.out.println("LocalDate:"+ LocalDate.of(2018,8,18));
        System.out.println("LocalTime"+ LocalTime.of(6,30,19));
        System.out.println("LocalDateTime"+LocalDateTime.of(2018,8,18,20,0,0));
    }
}
