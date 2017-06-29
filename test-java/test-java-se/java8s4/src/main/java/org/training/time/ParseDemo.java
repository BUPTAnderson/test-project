package org.training.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by kongyunlong on 2016/10/8.
 */
public class ParseDemo {
    public static void main(String[] args) {
        String now = "12/16/2014";
        System.out.println(LocalDate.parse(now, DateTimeFormatter.ofPattern("MM/dd/yyyy")));

        System.out.println(LocalDate.from(DateTimeFormatter.ofPattern("MM/dd/yyyy").parse(now)));
        System.out.println(DateTimeFormatter.ofPattern("MM/dd/yyyy").parse(now, LocalDate::from));
    }
}
