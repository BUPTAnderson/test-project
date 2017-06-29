package org.training.time;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by kongyunlong on 2016/10/10.
 */
public class MethodAtDemo {
    public static void main(String[] args) {
        LocalDate d = LocalDate.now();
        LocalDateTime dt = d.atStartOfDay();
        System.out.println(dt);
        LocalDateTime dt2 = d.atTime(21, 6, 10);
        System.out.println(dt2);
    }
}
