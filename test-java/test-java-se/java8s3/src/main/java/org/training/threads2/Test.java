package org.training.threads2;

/**
 * Created by kongyunlong on 2016/6/26.
 */
class Run implements Runnable {
    private Resource r;

    public Run(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        r.increse();
    }
}

class Run2 implements Runnable {
    private Resource r;

    public Run2(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.decrese();
    }
}

public class Test {
    public static void main(String[] args) {
        Resource r = new Resource();
        Thread t1 = new Thread(new Run(r));
        t1.start();
        Thread t2 = new Thread(new Run(r));
        t2.start();
        Thread t3 = new Thread(new Run(r));
        t3.start();

        Thread t4 = new Thread(new Run2(r));
        t4.start();
    }
}
