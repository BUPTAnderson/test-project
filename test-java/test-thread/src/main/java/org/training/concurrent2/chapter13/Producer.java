package org.training.concurrent2.chapter13;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer extends Thread {
    private final MessageQueue messageQueue;
    private static final Random random = new Random(System.currentTimeMillis());
    private static final AtomicInteger counter = new AtomicInteger(0);

    public Producer(MessageQueue messageQueue, int seq) {
        super("PRODUCER-" + seq);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = new Message("Message-" + counter.getAndIncrement());
                messageQueue.put(message);
                System.out.println(Thread.currentThread().getName() + " put a message " + message.getData());
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
