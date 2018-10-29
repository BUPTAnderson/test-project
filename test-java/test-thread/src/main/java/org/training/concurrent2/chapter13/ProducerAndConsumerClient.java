package org.training.concurrent2.chapter13;

public class ProducerAndConsumerClient {
    public static void main(String[] args) {
        final MessageQueue messageQueue = new MessageQueue();
        new Producer(messageQueue, 1).start();
        new Producer(messageQueue, 2).start();
        new Producer(messageQueue, 3).start();
        new Consumer(messageQueue, 1).start();
        new Consumer(messageQueue, 2).start();
    }
}
