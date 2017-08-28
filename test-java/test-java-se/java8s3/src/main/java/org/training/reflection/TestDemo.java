package org.training.reflection;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anderson on 16-9-29.
 */
public class TestDemo {
    //该实例说明泛型类型会被擦除
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        Class c1 = strings.getClass();
        Class c2 = integers.getClass();
        TypeVariable[]  c1TypeParameters = c1.getTypeParameters();
        for (TypeVariable variable : c1TypeParameters) {
            System.out.println(variable.getTypeName()); //E
        }
        TypeVariable[]  c2TypeParameters = c2.getTypeParameters();
        for (TypeVariable variable : c2TypeParameters) {
            System.out.println(variable.getTypeName()); //E'
        }
        System.out.println(c1 == c2);
    }
}
