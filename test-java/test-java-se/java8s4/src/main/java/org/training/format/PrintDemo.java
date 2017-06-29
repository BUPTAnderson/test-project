package org.training.format;

/**
 * Created by kongyunlong on 2016/10/8.
 */
public class PrintDemo {
    public static void main(String[] args) {
        System.out.printf("%s,%s,%s \n", "a", "b", "c");
        //显示索引，1$对应第一个参数
        System.out.printf("%1$s,%3$s,%3$s \n", "a", "b", "c");
        //相对索引，<使用前面的索引
        System.out.printf("%1$s,%<s,%<s \n", "a", "b", "c");

        System.out.printf("%-4s\n", "a");

        System.out.printf("%06d\n", 123);

        System.out.printf("%(6d\n", -123);
        //转换成大写
        System.out.printf("%S\n", "a");
        //4.2 4是占位，2指精度，保留2位
        System.out.printf("%4.2s\n", "abc");
        //转换成8进制
        System.out.printf("%o", 10);
    }
}
