package org.training.io;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
//        Scanner in1=new Scanner(System.in);
//        System.out.println("What is your name？");
//        // 遇到回车结束，且原样接受
//        String name1=in1.nextLine();
//        System.out.println("你的姓名是"+name1);
//
//        Scanner in2=new Scanner(System.in);
//        System.out.println("What is your name？");
//        // 遇到非字符就结束，比如空格，tab，并且会去掉开头的非字符
//        String name2=in2.next();
//        System.out.println("你的姓名是"+name2);

        // netInt()和nextFloat()读取整数和浮点数及通过hasnextXxx进行判断
//        Scanner scan = new Scanner(System.in);
//        int i = 0 ;
//        float f = 0.0f ;
//        System.out.print("输入整数：");
//        if(scan.hasNextInt()){                 // 判断输入的是否是整数
//            i = scan.nextInt() ;
//            System.out.println("整数数据：" + i) ;
//        }else{                                 // 如果输入错误的信息
//            System.out.println("输入的不是整数！") ;
//        }
//        System.out.print("输入小数：");
//        if(scan.hasNextFloat()){               // 判断输入的是否是小数
//            f = scan.nextFloat() ;
//            System.out.println("小数数据：" + f) ;
//        }else{                                 //如果 输入错误的信息
//            System.out.println("输入的不是小数！") ;
//        }

        // netDouble()读取浮点数及输入多个数字求总和平均数
        Scanner scan = new Scanner(System.in);
        double sum = 0;
        int m = 0;
        // 输入非double就会结束
        while (scan.hasNextDouble()) {
            double x = scan.nextDouble();
            m = m + 1;
            sum = sum + x;
        }

        System.out.println(m + "个数的和为" + sum);
        System.out.println(m + "个数的平均值是" + (sum / m));
    }
}
