package org.training.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by kongyunlong on 2016/10/10.
 */
public class MethodPlusAndMinusDemo {
    public static void main(String[] args) {
        LocalDate d = LocalDate.of(2016, 10, 11);
        LocalDate d2 = d.plus(1, ChronoUnit.MONTHS);
        System.out.println(d2);
        LocalDate d3 = d.plusDays(2);
        System.out.println(d3);
    }
}
