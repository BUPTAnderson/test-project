package org.training.gc;

/**
 * Created by kongyunlong on 2016/7/9.
 */
public class FinalizerDemo {
    private int id;

    public FinalizerDemo(int id) {
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        if (id % 100 == 0) {
            System.out.println(id);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new FinalizerDemo(i);
        }
        System.gc();
    }
}
