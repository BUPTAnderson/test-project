package org.training.reflection;

/**
 * Created by kongyunlong on 2016/5/29.
 */
class User{
    public User()
    {
        System.out.println("----------------");
    }

    static {
        System.out.println("User init...");
    }

    {
        System.out.println("+++++++++++++++++++");
    }
}

public class ReflectionDemo1 {
    static void create1() {
        new User();
    }

    static void create2() {
        Class<User> c = User.class;
    }

    static void create3() {
        try {
            Class c = Class.forName("org.training.reflection.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void create4() {
        try {
            Class c = Class.forName("com.jd.reflection.User", false, ReflectionDemo1.class.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void create5() {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try {
            Class<?> s = loader.loadClass("com.jd.reflection.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        create1();
//        create2();
        // 会调用static代码块, 不会调用构造块和构造方法
        create3();
//        create4();
//        create5();
//        Class<String> c = String.class;
//        String s = "";
//        Class<?> c1 = s.getClass();
//        try {
//            Class<?> c2 = Class.forName("java.lang.String");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        System.out.println(int.class == Integer.TYPE);
    }
}
