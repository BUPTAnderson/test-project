package org.training.enums;

/**
 * Created by kongyunlong on 2016/6/11.
 */

public class TestNum {
    public static void main(String[] args) {
        Season e1 = Season.SPRING;
        Season[] s = Season.values();
        for (Season season : s) {
            System.out.println(season.name());   //SPRING,SUMMER,AUTUMN,WINTER
            System.out.println(season.ordinal()); //序号,从0开始递增
        }
        Season s1 = Season.valueOf("AUTUMN");
        System.out.println(s1.ordinal());     //2
//        Season s2 = Season.valueOf("autumn"); //枚举大小写敏感，抛出异常 IllegalArgumentException

        Season s3 = Enum.valueOf(Season.class, "AUTUMN");
        System.out.println(s3.ordinal());
    }
}
