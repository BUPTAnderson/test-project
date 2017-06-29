package org.training.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;

/**
 * Created by kongyunlong on 2016/10/8.
 */
public class AdjusterDemo {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        //下周一
        LocalDate d = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(d);
        //当前月份的第6个周二，不够向下个月顺延，如果是负数，如-6，当前月倒数第6个周二，不够上延
        LocalDate d2 = now.with(TemporalAdjusters.dayOfWeekInMonth(6,
                DayOfWeek.TUESDAY));
        System.out.println(d2);

        //ofDateAdjuster的参数实际是Function<T, T>,方法是T apply(T t)
        TemporalAdjuster adjuster = TemporalAdjusters.ofDateAdjuster((
                LocalDate date) -> date.plusMonths(3).plusDays(2));
        System.out.println(d.with(adjuster));

        TemporalQuery<LocalDate> d5 = TemporalQueries.localDate();
        System.out.println(now.query(d5));

        TemporalQuery<TemporalUnit> d6 = TemporalQueries.precision();
        LocalTime nowTime = LocalTime.now();
        System.out.println(nowTime.query(d6));
    }
}
