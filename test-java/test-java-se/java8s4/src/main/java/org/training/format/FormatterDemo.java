package org.training.format;

import java.util.Formatter;

/**
 * Created by kongyunlong on 2016/10/8.
 */
public class FormatterDemo {
    public static void main(String[] args) {
        Formatter f1 = new Formatter();
        System.out.println(f1.format("%s,%s", "abc", "def"));
    }
}
