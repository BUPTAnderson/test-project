package org.training.enums;

/**
 * Created by kongyunlong on 2016/6/11.
 */
enum Season
{
    //    SPRING("spring"),SUMMER("summer"),AUTUMN("autumn"),WINTER("winter");
    SPRING("spring") {
        @Override
        public void m2()
        {
        }
    },
    SUMMER("summer") {
        @Override
        public void m2()
        {
        }
    }, AUTUMN("autumn") {
    @Override
    public void m2()
    {
    }
}, WINTER("winter") {
    @Override
    public void m2()
    {
    }
};
    String name;

    private Season(String name)
    {    //构造方法必须是私有的
        this.name = name;
        System.out.println("Season");
    }

    public String getName()
    {
        return name;
    }

    public abstract void m2();

    public static void main(String[] args)
    {
        Season spring = Season.SPRING;
        System.out.println(spring.getName());

        Season winter = Season.WINTER;
        winter.m2();

        Season winter2 = Season.WINTER;
        System.out.println(winter == winter2);
        System.out.println(winter.equals(winter2));
        //不同的枚举类型可以用equal()方法比较，但是结果是false
        System.out.println(Season.SPRING.equals(Gender.MALE));
        //不同的枚举类型不可以使用 == 来进行比较，会报语法错误
//        System.out.println(Season.SPRING == Gender.FEMALE);
    }
}
