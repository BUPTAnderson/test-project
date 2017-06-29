package org.training.time;

import java.time.Year;
import java.time.YearMonth;

/**
 * Created by kongyunlong on 2016/10/8.
 */
public class PartialDemo {
    public static void main(String[] args) {
        Year y = Year.of(2014);
        System.out.println(y);
        YearMonth ym = YearMonth.of(2014, 12);
        System.out.println(ym);
    }
}
