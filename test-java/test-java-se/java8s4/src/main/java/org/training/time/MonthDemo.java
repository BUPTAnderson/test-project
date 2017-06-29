package org.training.time;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by kongyunlong on 2016/10/8.
 */
public class MonthDemo {
    public static void main(String[] args) {
        Month m = Month.OCTOBER;
        LocalDate d = LocalDate.of(2013, m, 12);

        Month m1 = Month.of(10);
        System.out.println(m1 == m);

        System.out.println(m1.plus(1).getValue());
        System.out.println(Month.from(d).getValue());
    }
}
