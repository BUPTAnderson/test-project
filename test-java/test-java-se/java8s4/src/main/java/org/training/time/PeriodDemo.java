package org.training.time;

import java.time.Period;

/**
 * Created by kongyunlong on 2016/10/8.
 */
public class PeriodDemo {
    public static void main(String[] args) {
        Period p1 = Period.of(1, 2, 20);
        System.out.println(p1);

        System.out.println(p1.minusDays(21));
    }
}
