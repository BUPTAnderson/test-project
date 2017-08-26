package org.training.format;

import java.util.Locale;

/**
 * Created by kongyunlong on 2016/10/8.
 */
public class LocaleDemo {
    public static void main(String[] args) {
//        Locale locale = Locale.getDefault();
        Locale locale = Locale.US;
        System.out.println(locale.getCountry());
        System.out.println(locale.getLanguage());
        System.out.println(locale.getDisplayCountry());
        System.out.println(locale.getDisplayLanguage());

        Locale locale1 = new Locale("zh", "CN");
        System.out.println(locale1.getCountry());
        System.out.println(locale1.getLanguage());
        System.out.println(locale1.getDisplayCountry());
        System.out.println(locale1.getDisplayLanguage());
    }
}
