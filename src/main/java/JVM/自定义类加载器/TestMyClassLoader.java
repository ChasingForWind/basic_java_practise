package JVM.自定义类加载器;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMyClassLoader {
    public static void main(String[] args) throws Exception {
        //自定义类加载器的加载路径
        LiuchangClassLoader hClassLoader=new LiuchangClassLoader("/Users/liuchang/project/jike/jvm");
        //包名+类名
        Class c=hClassLoader.loadClass("Test");
        if(c!=null){
            Object obj=c.newInstance();
            Method method=c.getMethod("say", null);
            method.invoke(obj, null);
            System.out.println(c.getClassLoader().toString());
        }
    }
}
