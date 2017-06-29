package org.training.time;

import java.time.Clock;
import java.time.Instant;

/**
 * Created by kongyunlong on 2016/10/8.
 */
public class ClockDemo {
    public static void main(String[] args) {
        Clock c = Clock.systemDefaultZone();
        System.out.println(c.getZone());

        Instant i = c.instant();
        System.out.println(i);
        Instant i2 = Instant.now(c);
        System.out.println(i2);
    }
}
