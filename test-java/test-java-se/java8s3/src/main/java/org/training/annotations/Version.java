package org.training.annotations;

import org.training.enums.Gender;

/**
 * Created by kongyunlong on 2016/6/11.
 */
public @interface Version {
    int big();
    int small();
    //default null;不可以，默认值不能为null
    String name() default "abc" + "def";  //default new String(");错误，默认值是编译时实例
    Class c() default String.class;      //Class类型
    Annotation1 a() default @Annotation1; //注解类型
    Gender g() default Gender.MALE;     //枚举
    int[] nums() default {1, 2, 3};   //一维数组
//    String toString();  //不能定义Object和Annotation中定义的方法
    Gender[] gg();
}
