package org.training.time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

/**
 * Created by kongyunlong on 2016/10/10.
 */
public class MethodGetDemo {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2016, 10, 11, 20, 44, 30);
        int month = dt.get(ChronoField.MONTH_OF_YEAR);
        System.out.println(month);
        int day = dt.getDayOfMonth();
        System.out.println(day);
        int minute = dt.getMinute();
        System.out.println(minute);
    }
}
