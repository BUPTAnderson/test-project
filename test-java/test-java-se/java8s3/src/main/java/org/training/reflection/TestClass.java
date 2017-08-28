package org.training.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;
import java.util.Map;

/**
 * Created by anderson on 16-6-10.
 */

public class TestClass<K, V> {
    public int number;
    public K k;
    public TestClass<K, V> testClass;
    public List<? extends Number> numbers;
    public Map<K, List<V>>[] map;

    String getName(String pre) {
        return null;
    }

    <K> void m(V v) {
    }

    <T, S> void n(List<? extends Number> list, Map<K, List<V>> map) {
    }

    private class Inner {
    }

    public static class StaticInner {
    }

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        Class<TestClass> c = TestClass.class;
        Class<?>[] cs = c.getDeclaredClasses();
        //输出：
        //com.jd.reflection.TestClass$StaticInner
        //com.jd.reflection.TestClass$Inner
        for (Class c1 : cs) {
            System.out.println(c1.getName());
        }

        //要获取泛型类<>内的类型参数，要用方法getTypeParameters()
        TypeVariable[] variables = c.getTypeParameters();
        for (TypeVariable variable : variables) {
            //sun.reflect.generics.reflectiveObjects.TypeVariableImpl
            System.out.println(variable.getClass().getName());
            System.out.println(variable.getTypeName()); //K,V
            System.out.println(variable.getName()); //K,V
        }

        //普通变量，不含泛型
        Field number = c.getDeclaredField("number");
        if (number.getGenericType() instanceof Class) {
            Class nc = (Class) number.getGenericType();
            System.out.println(nc.getClass().getName()); //java.lang.Class
            System.out.println(nc.getTypeName()); //int
            System.out.println(number.getType().getName()); //int
        }

        Field f = c.getDeclaredField("k");
        //要获取属性的泛型类型，调用方法getGenericType()，K，T属于TypeVariable，TestClass<K,V>属于ParameterizedType
        if (f.getGenericType() instanceof TypeVariable) {
            TypeVariable ft = (TypeVariable) f.getGenericType();
            //输出 sun.reflect.generics.reflectiveObjects.TypeVariableImpl
            System.out.println(ft.getClass().getName());
            System.out.println(ft.getTypeName()); //K
            System.out.println(ft.getName()); //K
        }

        Field testClass = c.getDeclaredField("testClass");
        if (testClass.getGenericType() instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) testClass.getGenericType();
            //输出：sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
            System.out.println(parameterizedType.getClass().getName());
            //输出：com.jd.reflection.TestClass<K, V>
            System.out.println(parameterizedType.getTypeName());

            //输出：sun.reflect.generics.reflectiveObjects.TypeVariableImpl
            System.out.println(parameterizedType.getActualTypeArguments()[0].getClass().getName());
            String str = parameterizedType.getActualTypeArguments()[0].getTypeName();
            System.out.println(str); //K
            //sun.reflect.generics.reflectiveObjects.TypeVariableImpl
            System.out.println(parameterizedType.getActualTypeArguments()[1].getClass().getName());
            String str2 = parameterizedType.getActualTypeArguments()[1].getTypeName();
            System.out.println(str2); //V
        }

        Field numbers = c.getDeclaredField("numbers");
        if (numbers.getGenericType() instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) numbers.getGenericType();
            //输出：sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
            System.out.println(parameterizedType.getClass().getName());
            //输出：java.util.List<? extends java.lang.Number>
            System.out.println(parameterizedType.getTypeName());

            WildcardType wildcardType = (WildcardType) parameterizedType.getActualTypeArguments()[0];
            //输出：sun.reflect.generics.reflectiveObjects.WildcardTypeImpl
            System.out.println(wildcardType.getClass().getName());
            System.out.println(wildcardType.getTypeName()); //? extends java.lang.Number
            System.out.println(wildcardType.getUpperBounds()[0].getTypeName()); //java.lang.Number
        }

        Field lists = c.getDeclaredField("map");
        if (lists.getGenericType() instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) lists.getGenericType();
            //sun.reflect.generics.reflectiveObjects.GenericArrayTypeImpl
            System.out.println(genericArrayType.getClass().getName());

            ParameterizedType parameterizedType = (ParameterizedType) genericArrayType.getGenericComponentType();
            //sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
            System.out.println(parameterizedType.getClass().getName());
            //java.util.Map<K, java.util.List<V>>
            System.out.println(parameterizedType.getTypeName());
            if (parameterizedType.getActualTypeArguments()[0] instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) parameterizedType.getActualTypeArguments()[0];
                //sun.reflect.generics.reflectiveObjects.TypeVariableImpl
                System.out.println(typeVariable.getClass().getName());
                //K
                System.out.println(typeVariable.getTypeName());
            }
            if (parameterizedType.getActualTypeArguments()[1] instanceof ParameterizedType) {
                ParameterizedType parameterizedType1 = (ParameterizedType) parameterizedType.getActualTypeArguments()[1];
                //sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
                System.out.println(parameterizedType1.getClass().getName());
                //java.util.List<V>
                System.out.println(parameterizedType1.getTypeName());

                TypeVariable typeVariable = (TypeVariable) parameterizedType1.getActualTypeArguments()[0];
                //sun.reflect.generics.reflectiveObjects.TypeVariableImpl
                System.out.println(typeVariable.getClass().getName());
                //V
                System.out.println(typeVariable.getTypeName());
            }
        }

        //普通方法
        Method name = c.getDeclaredMethod("getName", String.class);
        TypeVariable<Method>[] tvs = name.getTypeParameters();
        System.out.println(tvs.length); //0
        Type[] ts = name.getGenericParameterTypes();
        for (Type type : ts) {
            System.out.println(type.getClass().getName()); //java.lang.Class
            System.out.println(type.getTypeName()); //java.lang.String
        }

        Method m = c.getDeclaredMethod("m", Object.class);
        //要获取<>内的类型参数，要用方法getTypeParameters()
        TypeVariable<Method>[] typeVariables = m.getTypeParameters();
        for (TypeVariable typeVariable : typeVariables) {
            //输出：sun.reflect.generics.reflectiveObjects.TypeVariableImpl
            System.out.println(typeVariable.getClass().getName());
            System.out.println(typeVariable.getName()); //K
        }
        Type[] types = m.getGenericParameterTypes();
        for (Type type : types) {
            //输出：sun.reflect.generics.reflectiveObjects.TypeVariableImpl
            System.out.println(type.getClass().getName());
            System.out.println(type.getTypeName()); //V
        }

        Method n = c.getDeclaredMethod("n", List.class, Map.class);
        //要获取<>内的类型参数，要用方法getTypeParameters()
        TypeVariable<Method>[] typeVariables2 = n.getTypeParameters();
        for (TypeVariable typeVariable : typeVariables2) {
            //输出：sun.reflect.generics.reflectiveObjects.TypeVariableImpl
            System.out.println(typeVariable.getClass().getName());
            System.out.println(typeVariable.getName()); //分别输出T，S
        }
        Type[] types2 = n.getGenericParameterTypes();
        for (Type type : types2) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                //sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
                System.out.println(parameterizedType.getClass().getName());
                if (parameterizedType.getActualTypeArguments().length == 1) {
                    WildcardType wildcardType = (WildcardType) parameterizedType.getActualTypeArguments()[0];
                    //sun.reflect.generics.reflectiveObjects.WildcardTypeImpl
                    System.out.println(wildcardType.getClass().getName());
                    //? extends java.lang.Number
                    System.out.println(wildcardType.getTypeName());
                    //java.lang.Number
                    System.out.println(wildcardType.getUpperBounds()[0].getTypeName());
                } else if (parameterizedType.getActualTypeArguments().length == 2) {
                    TypeVariable typeVariable = (TypeVariable) parameterizedType.getActualTypeArguments()[0];
                    //sun.reflect.generics.reflectiveObjects.TypeVariableImpl
                    System.out.println(typeVariable.getClass().getName());
                    //K
                    System.out.println(typeVariable.getTypeName());
                    ParameterizedType p = (ParameterizedType) parameterizedType.getActualTypeArguments()[1];
                    //sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
                    System.out.println(p.getClass().getName());
                    //sun.reflect.generics.reflectiveObjects.TypeVariableImpl
                    System.out.println(p.getActualTypeArguments()[0].getClass().getName());
                    //V
                    System.out.println(p.getActualTypeArguments()[0].getTypeName());
                }
            }
        }
    }
}
