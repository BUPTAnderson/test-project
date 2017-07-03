package org.training.enums;

/**
 * Created by kongyunlong on 2016/6/11.
 */
public class SwitchDemo {
    public static String getSeason(Season s) {
        switch (s){
            case SPRING:            //写成Season.SPRING会报错
                return "spring";
            case SUMMER:
                return "summer";
            case AUTUMN:
                return "autumn";
            case WINTER:
                return "winter";
//            default:              //default不能省略
//                return "";
        }
        return null;
    }
    public static void main(String[] args) {
        //getSeason(Season s)参数只能是枚举的有效实例，如果传入null，语法上没问题，但是运行会报.NullPointerException
//        Season s = Season.SPRING;
//        System.out.println(getSeason(s));
        Season spring = Season.SPRING;
        System.out.println(spring.getName());
    }
}
