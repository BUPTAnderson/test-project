package org.training.reflection;

import java.lang.reflect.Field;

/**
 * Created by kongyunlong on 2016/5/29.
 */
interface  Interface1 {
    int NUM = 10;
}

class Class1 {
    int num1;
    public String name;
}

class MyClass extends Class1 implements Interface1 {
    int num2;
    public int num3;
    private int num4;
}

public class FieldInfo {
    public static void main(String[] args) {
        Class<MyClass> c = MyClass.class;
        Field[] fields1 = c.getFields();            //只能得到所有的public属性，包括继承来的属性
        for (Field field : fields1) {
            System.out.println(field.getName());
        }
        System.out.println("------------------------");
        Field[] fields2 = c.getDeclaredFields();    //获取当前类声明的所有属性，不包括继承来的属性，declare，声明的
        for (Field field : fields2) {
            System.out.println(field.getName());
        }
        System.out.println("------------------------");
        try {
            Field f1 = c.getField("num2");          //NoSuchFieldException，因为getField()只能获取public属性，包括继承来的属性
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            Field f1 = c.getDeclaredField("num2");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
