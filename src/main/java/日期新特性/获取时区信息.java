package 日期新特性;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class 获取时区信息 {
    public static void main(String[] args) {
        // 获取所有时区信息
        for (String s: ZoneId.getAvailableZoneIds()){
            System.out.println(s);
        }
        // 获取当前时区信息
        System.out.println(ZoneId.systemDefault());
        // 时区转换
        LocalDateTime time = LocalDateTime.of(2018, 8, 18, 20, 0, 0);
        System.out.println("上海："+ time.atZone(ZoneId.of("Asia/Shanghai")));
        System.out.println("东京："+time.atZone(ZoneId.of("Asia/Tokyo")));
    }

}
