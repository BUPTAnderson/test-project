package org.training.time;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by kongyunlong on 2016/10/8.
 */
public class NewTimeDemo {
    public static void main(String[] args) {
        LocalDate d = LocalDate.now();
        System.out.println(d.getYear() + "," + d.getMonthValue() + ","
        + d.getDayOfMonth());
        System.out.println(d);

        LocalTime t = LocalTime.now();
        System.out.println(t);

        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);

        LocalDate d1 = LocalDate.of(2016, 10, 9);
        LocalTime t1 = LocalTime.of(12, 4, 7);
        System.out.println(d1);
        System.out.println(t1);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        System.out.println("timestamp:" + timestamp);
    }
}
