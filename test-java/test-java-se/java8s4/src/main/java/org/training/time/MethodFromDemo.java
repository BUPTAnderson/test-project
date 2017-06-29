package org.training.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by kongyunlong on 2016/10/10.
 */
public class MethodFromDemo {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2016, 10, 10, 20, 44, 30);
        LocalDate d = LocalDate.from(dt);
        System.out.println(d);
        LocalTime t = LocalTime.from(dt);
        System.out.println(t);
    }
}
