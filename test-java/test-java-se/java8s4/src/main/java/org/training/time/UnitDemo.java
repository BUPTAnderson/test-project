package org.training.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by kongyunlong on 2016/10/8.
 */
public class UnitDemo {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now.plus(4, ChronoUnit.DAYS));
        System.out.println(now.plus(4, ChronoUnit.WEEKS));
    }
}
