package org.training.time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

/**
 * Created by kongyunlong on 2016/10/8.
 */
public class FieldDemo {
    public static void main(String[] args) {
        LocalDateTime t = LocalDateTime.now();
        System.out.println(t.get(ChronoField.YEAR));
        System.out.println(t.get(ChronoField.MONTH_OF_YEAR));
    }
}
