package org.training.time;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * Created by anderson on 17-2-14.
 */
public class EpochMilliDemo {
//    SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        System.out.println(dateTimeFormatter.format(dateTimeFormatter.parse("2015-11-01 12:00:01.00")));
//        System.out.println(dateTimeFormatter.format(dateTimeFormatter.parse("2015-11-01 12:00:01.0")));
//        System.out.println(dateTimeFormatter.format(dateTimeFormatter.parse("2015-11-01 12:00:01.9")));
//        System.out.println(dateTimeFormatter.format(dateTimeFormatter.parse("2015-11-01 12:00:01.09")));
//        System.out.println(dateTimeFormatter.format(dateTimeFormatter.parse("2015-11-01 12:00:01.009")));
//        System.out.println(dateTimeFormatter.format(dateTimeFormatter.parse("2015-11-01 12:00:01.90")));
//        System.out.println(dateTimeFormatter.format(dateTimeFormatter.parse("2015-11-01 12:00:01.900")));
//        System.out.println("------------------");
//        f1.parse("2015-11-01 12:00:01.9").getLong()
//        f1.parse("2015-11-01 12:00:01.9");
//        System.out.println(f2.format(f1.parse("2015-11-01 12:00:01.9")));
//        System.out.println(localDateTime.toEpochSecond(ZoneOffset.UTC));
//        Duration.parse("2015-11-01 12:00:01.9");
//        long time = Duration.between(Instant.ofEpochMilli(0L), localDateTime1).toMillis();
//        Instant.now().toEpochMilli();
//        Instant.parse("2015-11-01 12:00:01.9").

    public static void main(String[] args) {
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        LocalDateTime localDateTime1 = LocalDateTime.parse("2015-11-01 12:00:01.9", f1);
        long toEpochMilli = localDateTime1.toInstant(ZoneOffset.UTC).toEpochMilli();
        System.out.println(toEpochMilli);
    }
}
