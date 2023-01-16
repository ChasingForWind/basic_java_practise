package 日期新特性;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class 精准修改时间 {
    public static void main(String[] args) {

        // with 方法
        LocalDate localDate = LocalDate.of(2022, 11, 20);
        System.out.println("修改前的时间："+ localDate);
        System.out.println("精准修改后的时间日："+ localDate.withDayOfMonth(12));
        System.out.println("精准修改后的时间每月1号："+ localDate.with(ChronoField.DAY_OF_MONTH,1));

        // with 方法和temperAdjuster方法的使用
        LocalDate now = LocalDate.now();
        System.out.println("当前日期："+ now);
        System.out.println("当月第一天："+now.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("当年第一天："+now.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println("当月最后一天："+now.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("下一年的第一天："+now.with(TemporalAdjusters.firstDayOfNextYear()));

        // with方法和temperAdjusters方法使用
        System.out.println("下个周一："+ now.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
        System.out.println("上个周三："+ now.with(TemporalAdjusters.previous(DayOfWeek.WEDNESDAY)));
        System.out.println("上周三："+ now.with(TemporalAdjusters.previous(DayOfWeek.WEDNESDAY)).plus(-1, ChronoUnit.WEEKS));



    }
}
