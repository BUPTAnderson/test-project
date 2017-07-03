package org.training.enums;

/**
 * Created by kongyunlong on 2016/6/11.
 */
class Test{
    //相当于静态内部类
    public enum Gender2{
        MALE, FEMAL
    }
}

interface Interface1{
    void m();
}

enum Enum2 implements Interface1{
    ABC {
        @Override
        public void m() {
            System.out.println("abc");
        }
    }, CDE {
        @Override
        public void m() {
            System.out.println("cde");
        }
    };

    @Override
    public void m() {
    }
}

public class NestedEnum {
    public static void main(String[] args) {
        Test.Gender2 gender = Test.Gender2.FEMAL;
        System.out.println(gender.name());   //FEMAL
    }
}
