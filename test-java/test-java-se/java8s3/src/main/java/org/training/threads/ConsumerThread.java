package org.training.threads;

/**
 * Created by kongyunlong on 2016/6/26.
 */
public class ConsumerThread implements Runnable {
    private Resource resource;

    public ConsumerThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.decrese();
        }
    }
}
