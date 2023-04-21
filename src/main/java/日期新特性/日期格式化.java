package 日期新特性;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class 日期格式化 {
    public static void main(String[] args) {

        // 格式化
        LocalDateTime now = LocalDateTime.now();

        String s1 = now.format(DateTimeFormatter.ISO_DATE);
        String s2 = now.format(DateTimeFormatter.ISO_DATE_TIME);

        System.out.println("原有日期："+ now);
        System.out.println("格式化1："+ s1);
        System.out.println("格式化2："+ s2);

        // 格式化2

        String s3 = now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        String s4 = now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG));
        String s5 = now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        String s6 = now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));

        System.out.println("默认格式化1："+s3);
        System.out.println("默认格式化2："+s4);
        System.out.println("默认格式化3："+s5);
        System.out.println("默认格式化4："+s6);

        // 格式化3
        String s7 = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm---ss"));
        System.out.println("自定义格式化："+s7);

        // 反格式化
        LocalDateTime parsed = LocalDateTime.parse(s2);
        System.out.println("反格式化之后的日期:"+ parsed);

        String ss = "2023-02-12 15:24---29";
        LocalDateTime parsed2 = LocalDateTime.parse(ss,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm---ss"));
        System.out.println("反格式化之后的日期："+ parsed2);

    }
}
