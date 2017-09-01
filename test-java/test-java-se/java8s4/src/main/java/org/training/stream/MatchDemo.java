package org.training.stream;

/**
 * Created by anderson on 17-8-29.
 */
public class MatchDemo
{
    public static void main(String[] args)
    {
        // steam中的元素是否都是male
        boolean b = Person.persons().stream().allMatch(Person::isMale);
        System.out.println(b);

        // 是否有元素的生日是1990年
        b = Person.persons().stream().anyMatch(p -> p.getBirthDate().getYear() == 1990);
        System.out.println(b);

        // 是不是没有一个人的工资大于6000
        b = Person.persons().stream().noneMatch(p -> p.getIncome() > 6000);
        System.out.println(b);
    }
}
