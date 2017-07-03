package org.training.annotations;

/**
 * Created by kongyunlong on 2016/6/11.
 */
public class TestAnnotation {
    @Test(num = 10)
    public void testAdd() {
        System.out.println("Hello Add");
    }

    public void testDiv() {
        System.out.println("Hello Div");
    }
}
