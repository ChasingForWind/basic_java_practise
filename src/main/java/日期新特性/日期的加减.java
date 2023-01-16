package 日期新特性;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class 日期的加减 {
    public static void main(String[] args) {

        // 常规加减
        LocalDate localDate = LocalDate.of(2018, 1, 1);
        System.out.println("加一天："+localDate.plusDays(1));
        System.out.println("加一个月："+localDate.plusMonths(1));
        System.out.println("加一年："+localDate.plusYears(1));


        LocalTime localTime = LocalTime.of(8, 14, 39, 218);
        System.out.println("当前时间："+localTime);
        System.out.println("加100纳秒："+localTime.plusNanos(100));
        System.out.println("加100秒："+localTime.plusSeconds(100));
        System.out.println("加100分钟："+localTime.plusMinutes(100));
        System.out.println("加100小时："+localTime.plusHours(100));

        // period 类封装一段时间,1年2个月3天
        Period period = Period.of(1, 2, 3);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("相对当前时间1年2个月3天后的时间："+localDateTime.plus(period));

        // 特殊封装日期
        LocalDateTime time = LocalDateTime.of(2000, 1, 1, 1, 1, 11);
        System.out.println("加上半天："+time.plus(1, ChronoUnit.HALF_DAYS));
        System.out.println("加上一个十年："+time.plus(1, ChronoUnit.DECADES));
    }
}
