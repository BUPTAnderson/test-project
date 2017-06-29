package org.training.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by kongyunlong on 2016/10/10.
 */
public class MethodToDemo {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2016, 10, 11, 20, 44, 30);
        LocalDate d = dt.toLocalDate();
        System.out.println(d);
        LocalTime t = dt.toLocalTime();
        System.out.println(t);
    }
}
