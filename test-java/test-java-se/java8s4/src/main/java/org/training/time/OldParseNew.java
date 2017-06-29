package org.training.time;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by anderson on 17-1-22.
 */
public class OldParseNew {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
    }

    public static LocalDateTime convertFromDate(Date source) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault());
        return dateTime;
    }

    public static Date convertFromLocalDateTime(LocalDateTime localDateTime) {
        Date convertToDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return convertToDate;
    }

    public static LocalDateTime converFromTimestamp(Timestamp timestamp) {
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        return localDateTime;
    }

    public static Timestamp convertFromLocalDateTime2(LocalDateTime localDateTime) {
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        return timestamp;
    }
}
