package org.training.concurrent.chapter9;

import java.util.stream.Stream;

/**
 * 这个代码是有问题的，各个线程会hung住，但是不是出现了死锁。原因是使用的notify()只会唤醒单个线程，
 * 如果把notify()换成notifyAll()则正确
 * <p>
 * notify():
 * 唤醒在此对象监视器上等待的单个线程。如果所有线程都在此对象上等待，则会选择唤醒其中一个线程。选择是任意性的，并在对实现做出决定时发生。线程通过调用其中一个 wait 方法，在对象的监视器上等待。
 * 直到当前线程放弃此对象上的锁定，才能继续执行被唤醒的线程。被唤醒的线程将以常规方式与在该对象上主动同步的其他所有线程进行竞争；例如，唤醒的线程在作为锁定此对象的下一个线程方面没有可靠的特权或劣势。
 * <p>
 * notifyAll():
 * 唤醒在此对象监视器上等待的所有线程。线程通过调用其中一个 wait 方法，在对象的监视器上等待。
 * 直到当前线程放弃此对象上的锁定，才能继续执行被唤醒的线程。被唤醒的线程将以常规方式与在该对象上主动同步的其他所有线程进行竞争；例如，唤醒的线程在作为锁定此对象的下一个线程方面没有可靠的特权或劣势。
 */
public class ProducerConsumerVersion2 {
    private int i = 0;
    private static final Object LOCK = new Object();

    private volatile boolean isProduced = false;

    public void produce() {
        synchronized (LOCK) {
            if (isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                i++;
                System.out.println(Thread.currentThread().getName() + " P->" + i);
                LOCK.notifyAll();
                isProduced = true;
            }
        }
    }

    public void consume() {
        synchronized (LOCK) {
            if (isProduced) {
                System.out.println(Thread.currentThread().getName() + " c->" + i);
                LOCK.notifyAll();
                isProduced = false;
            } else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumerVersion2 pc = new ProducerConsumerVersion2();
        Stream.of("P1", "P2", "p3", "p4").forEach(n ->
                new Thread() {
                    @Override
                    public void run() {
                        while (true) {
                            pc.produce();
                        }
                    }
                }.start());

        Stream.of("C1", "C2", "c3", "c4").forEach(n ->
                new Thread() {
                    @Override
                    public void run() {
                        while (true) {
                            pc.consume();
                        }
                    }
                }.start());
    }
}
