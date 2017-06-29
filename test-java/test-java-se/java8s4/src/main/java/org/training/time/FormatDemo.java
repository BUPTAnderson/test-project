package org.training.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;

/**
 * Created by kongyunlong on 2016/10/8.
 */
public class FormatDemo {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(DateTimeFormatter.ISO_DATE.format(now));

        System.out.println(now.format(DateTimeFormatter.ISO_DATE));

        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        System.out.println(f1.format(now));

        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(f2.format(LocalDateTime.now()));

        DateTimeFormatter f3 = new DateTimeFormatterBuilder()
                .appendValue(ChronoField.YEAR)
                .appendLiteral("年的圣诞节是")
                .appendText(ChronoField.DAY_OF_WEEK, TextStyle.FULL_STANDALONE)
                .toFormatter();
        LocalDate d = LocalDate.of(2014, 12, 25);
        System.out.println(f3.format(d));
    }
}
