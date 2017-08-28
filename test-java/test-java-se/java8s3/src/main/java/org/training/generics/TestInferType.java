package org.training.generics;

/**
 * Created by kongyunlong on 2016/5/28.
 */
class User<T> {
   public User(T t){}
   public User(){}
}

public class TestInferType {
    static void test(User<String> user){
    }

    public static void main(String[] args) {
        User<String> user1 = new User<>("Tom"); //从构造方法参数推断类型
        User<String> user2 = new User<>();   //从赋值运算符的左边推断类型。

        test(new User<>()); //java7中该语句报错，java8中会从方法的形式参数中推断
    }
}
