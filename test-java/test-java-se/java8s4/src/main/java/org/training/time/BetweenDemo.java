package org.training.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by kongyunlong on 2016/10/8.
 */
public class BetweenDemo {
    public static void main(String[] args) {
        LocalDate d1 = LocalDate.of(2013, 12, 1);
        LocalDate d2 = LocalDate.now();
        long days = ChronoUnit.DAYS.between(d1, d2);
        System.out.println(days);

        System.out.println(d1.until(d2));
        System.out.println(d1.until(d2, ChronoUnit.MONTHS));

        //下面的用法会抛出异常，不能将LocalDate与LocalTime进行比较
        LocalTime t = LocalTime.now();
//        long days1 = ChronoUnit.MONTHS.between(d1, t);
//        System.out.println(days1);

        LocalTime t1 = LocalTime.of(18, 10);
        System.out.println(ChronoUnit.MINUTES.between(t, t1));
    }
}
