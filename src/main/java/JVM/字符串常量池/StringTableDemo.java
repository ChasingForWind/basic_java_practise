package JVM.字符串常量池;

import java.util.HashMap;

public class StringTableDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("hello", 53);
        map.put("world", 35);
        map.put("java", 55);
        map.put("world", 52);
        map.put("通话", 51);
        map.put("重地", 55);
//出现哈希冲突怎么办？
//System.out.println("map = " + map);//
        test();
    }

    public static void test() {
        String str1 = "abc";  // 编译时，加入常量池
        String str2 = new String("abc"); // 运行时创建
        System.out.println(str1 == str2);//false


        String str3 = new String("abc"); // 运行时创建
        System.out.println(str3 == str2);//false

        String str4 = "a" + "b";  // 编译时，"ab" 加入常量池
        System.out.println(str4 == "ab");//true

        String s1 = "a";
        String s2 = "b";
        String str6 = s1 + s2;  // 运行时创建
        System.out.println(str6 == "ab");//false

        String str7 = "abc".substring(0, 2); // 运行时创建
        System.out.println(str7 == "ab");//false

        String str8 = "abc".toUpperCase(); // 运行时创建
        System.out.println(str8 == "ABC");//false

        String s5 = "a";
        String s6 = "abc";
        String s7 = s5 + "bc";
        System.out.println(s6 == s7.intern());//true intern() 会将运行时创建的常量加入常量池
    }
}
