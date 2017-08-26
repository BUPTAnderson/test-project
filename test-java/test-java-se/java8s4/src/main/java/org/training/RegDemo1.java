package org.training;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kongyunlong on 2017/8/26.
 */
public class RegDemo1 {
    public static void main(String[] args) {
        String reg = "a[def]c";
        String s = "abc";
        System.out.println(s.matches(reg));
        System.out.println("cdeabcadcbhafca".replaceAll(reg, "X"));
        System.out.println("cdeabcadcbhafca".replaceFirst(reg, "X"));

        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher("cdeabcadcbhafca");
//        System.out.println(matcher.find());
        while (matcher.find()) {
            System.out.println(matcher.start() + ", " + matcher.end());
        }
    }
}
