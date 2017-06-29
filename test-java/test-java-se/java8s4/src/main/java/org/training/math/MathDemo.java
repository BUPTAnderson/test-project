package org.training.math;

import java.util.Random;

/**
 * Created by kongyunlong on 2016/10/15.
 */
public class MathDemo {
    public static void main(String[] args) {
        //绝对值
        System.out.println(Math.abs(-12.34));
        //向上取整
        System.out.println(Math.ceil(1.2));
        //向下取整
        System.out.println(Math.floor(2.9));
        System.out.println(Math.floor(-2.1));
        System.out.println(Math.max(12, 11));

        for (int i = 0; i < 10; i++) {
            System.out.println(Math.random());
        }

        Random r1 = new Random();
        //输出0~9的随机数
        for (int i = 0; i < 10; i++) {
            System.out.println(r1.nextInt(10));
        }

        System.out.println("-----------------------------");
        //指定种子数10，则不管运行多少次，输出顺序永远是
        //3,0,3,0,6,6,7,8,1,4......
        Random r2 = new Random(10);
        //输出0~9的随机数
        for (int i = 0; i < 10; i++) {
            System.out.println(r2.nextInt(10));
        }
    }
}
