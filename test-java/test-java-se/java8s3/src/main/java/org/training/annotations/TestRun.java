package org.training.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by kongyunlong on 2016/6/11.
 */
public class TestRun {
    public static void main(String[] args) {
        Class<TestAnnotation> c = TestAnnotation.class;
        Method[] ms = c.getDeclaredMethods();
        for (Method method : ms) {
            if (method.isAnnotationPresent(Test.class)) {
                Test t = method.getAnnotation(Test.class);
                int num = t.num();
                System.out.println(num);
                if (num < 10) {
                    continue;
                }
                try {
                    method.invoke(c.newInstance());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
