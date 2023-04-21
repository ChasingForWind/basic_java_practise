package 日期新特性;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * 员工在每月15号领取工资，如果当月15号是周末，就改为上个周五领工资
 */
public class 自定义日期调节器 implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal date) {
        // 获取每月15号
        int day = 15;
        LocalDate realDay = LocalDate.from(date).withDayOfMonth(day);

        // 如果是周末就改为上周五
        if (realDay.getDayOfWeek()== DayOfWeek.SUNDAY||realDay.getDayOfWeek()==DayOfWeek.SATURDAY){
            return realDay.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        }
        return realDay;
    }

    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2023,1,1);
        自定义日期调节器 adjuster = new 自定义日期调节器();
        for (int i = 0; i < 12 ; i++) {
            int month = i+1;
            System.out.println("第"+month+"月的发薪日是："+adjuster.adjustInto(start.plusMonths(i)));
        }
    }
}
