package org.training.reflection;

import java.lang.reflect.Array;

/**
 * Created by kongyunlong on 2016/6/10.
 */
public class CatTest {
    public static void main(String[] args) {
//        Cat[] cats = (Cat[])Array.newInstance(Cat.class, 10);
//        cats[0] = new Cat();
//        System.out.println(cats.length);
//
//        int[] nums = (int[])Array.newInstance(int.class, 5);
////        Integer[] nums2 = (Integer[])Array.newInstance(int.class, 5);  //这句表达式会报ClassCastException异常
//        System.out.println(new String[10]); // [Ljava.lang.String;@4554617c 数组额输出开头为[L
//        int[][] nums2 = (int[][])Array.newInstance(int.class, 3, 5);
//        System.out.println(nums2.length);
//        System.out.println(nums2.getClass().isArray());

        int[][] num3 = (int[][]) Array.newInstance(int.class, 2, 3);
        System.out.println(num3.getClass().isArray());
        Array.setInt(num3[0], 0, 10);
        Array.setInt(num3[0], 1, 20);
        Array.setInt(num3[0], 2, 30);
        Array.setInt(num3[1], 0, 40);
        Array.setInt(num3[1], 1, 50);
        Array.setInt(num3[1], 2, 60);
        for (int i = 0; i < num3.length; i++) {
            for (int j = 0; j < num3[i].length; j++) {
                System.out.println(Array.getInt(num3[i], j));
            }
        }
        System.out.println(num3.getClass().isArray());
        Cat[] cats = (Cat[]) Array.newInstance(Cat.class, 10); //true,判断是否为数组
        System.out.println(cats.getClass().getComponentType().getName()); //com.jd.reflection.Cat
        System.out.println(Array.getLength(cats)); //10
    }
}
