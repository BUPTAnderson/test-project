package org.training.time;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by kongyunlong on 2016/10/10.
 */
public class MethodOfDemo {
    public static void main(String[] args) {
        LocalDate d1 = LocalDate.of(2014, Month.JANUARY, 25);
        System.out.println(d1);
        LocalDate d2 = LocalDate.of(2014, 1, 25);
        System.out.println(d2);
        LocalDate d3 = LocalDate.ofEpochDay(16095L);
        System.out.println(d3);
        LocalDate d4 = LocalDate.ofYearDay(2014, 25);
        System.out.println(d4);
    }
}
