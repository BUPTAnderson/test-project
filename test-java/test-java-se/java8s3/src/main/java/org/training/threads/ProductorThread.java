package org.training.threads;

/**
 * Created by kongyunlong on 2016/6/26.
 */
public class ProductorThread implements Runnable {
    private Resource resource;

    public ProductorThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.increse();
        }
    }
}
