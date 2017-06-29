package org.training.time;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoField;

/**
 * Created by kongyunlong on 2016/10/10.
 */
public class MethodWithDemo {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2016, 10, 10, 20, 44, 30);
        LocalDateTime dt1 = dt.withDayOfMonth(11);
        System.out.println(dt1);
        LocalDateTime dt2 = dt.with(Month.NOVEMBER);
        System.out.println(dt2);
        LocalDateTime dt3 = dt.with(ChronoField.DAY_OF_YEAR, 300);
        System.out.println(dt3);
    }
}
