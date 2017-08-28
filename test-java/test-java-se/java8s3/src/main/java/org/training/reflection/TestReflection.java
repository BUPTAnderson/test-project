package org.training.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/**
 * Created by kongyunlong on 2016/6/10.
 */
class Bird<T> {
    void m(T t) {
        System.out.println(t);
    }
}

public class TestReflection {
    Bird<? extends  String> b = new Bird<>();
    <V> void m() {
    }

    Bird<String>[] bs = new Bird[10];

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        Bird<String>.class;   //语法错误
        Class<TestReflection> c = TestReflection.class;
        Field f1 = c.getDeclaredField("b");
        System.out.println(f1.getType().getName()); //com.jd.reflection.Bird
        if (f1.getGenericType() instanceof ParameterizedType) {
            System.out.println("Bird<? extends  String> type:" + f1.getGenericType().getClass().getName()); //ParameterizedTypeImpl
            String str = ((ParameterizedType) f1.getGenericType())
                    .getActualTypeArguments()[0].getTypeName();
            System.out.println(str);   //? extends java.lang.String
            System.out.println("? extends  String Type:" + ((ParameterizedType) f1.getGenericType()).getActualTypeArguments()[0].getClass().getName()); //WildcardTypeImpl
            if (((ParameterizedType) f1.getGenericType())
                    .getActualTypeArguments()[0] instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) ((ParameterizedType) f1.getGenericType())
                        .getActualTypeArguments()[0];
                System.out.println(wildcardType.getUpperBounds()[0].getTypeName());  //java.lang.String 获取通配符的上边界
            }
        }
        System.out.println("----------+++------------");
        Method m = c.getDeclaredMethod("m");
        TypeVariable<Method> t = m.getTypeParameters()[0];
        System.out.println(t.getName());    //V
        System.out.println("----------^^^--------------");
        Field f2 = c.getDeclaredField("bs");
        if (f2.getGenericType() instanceof GenericArrayType) {
            //com.jd.reflection.Bird<java.lang.String>
            System.out.println("+++:" + ((GenericArrayType) f2.getGenericType()).getGenericComponentType().getClass().getName()); //ParameterizedTypeImpl
            System.out.println(((GenericArrayType) f2.getGenericType()).getGenericComponentType().getTypeName());
            ParameterizedType p = ((ParameterizedType) ((GenericArrayType) f2.getGenericType()).getGenericComponentType());
            System.out.println(p.getActualTypeArguments()[0].getTypeName());
            if (p.getActualTypeArguments()[0] instanceof TypeVariable) {
                System.out.println("####");
            }
            System.out.println(p.getActualTypeArguments()[0].getClass().getName());
        }

        System.out.println("--------------------");
        Bird<String> b1 = new Bird<>();
        b1.m("abc");  //输出abc
//        b1.m(1);    //编译错误
        Class<?> c2 = b1.getClass();
        Method m2 = c2.getDeclaredMethod("m", Object.class);
        m2.invoke(b1, "cde");      //输出cde
        m2.invoke(b1, 1);          //输出1
    }
}
