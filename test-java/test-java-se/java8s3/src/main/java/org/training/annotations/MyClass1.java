package org.training.annotations;

import java.lang.annotation.Annotation;

/**
 * Created by kongyunlong on 2016/6/11.
 */
public class MyClass1 implements Annotation1 {
    @Override
    public Class<? extends Annotation> annotationType() {
        return Annotation1.class;
    }
}
