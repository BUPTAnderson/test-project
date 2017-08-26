package org.training.time;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by kongyunlong on 2017/8/26.
 */
public class DateDemo1 {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d.getTime());

        Date d1 = new Date();
        d1.setTime(1503741333826L);

        System.out.println(d.after(d1));

        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月" + c.get(Calendar.DATE));
        c.add(Calendar.YEAR, -7);
        System.out.println(c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月" + c.get(Calendar.DATE));
        // 没有产生进位
        c.roll(Calendar.DATE, 20);
        // 会产生进位
//        c.add(Calendar.DATE, 20);
        // true：加1， false：减1
//        c.roll(Calendar.DATE, true);
        System.out.println(c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月" + c.get(Calendar.DATE));
    }
}
