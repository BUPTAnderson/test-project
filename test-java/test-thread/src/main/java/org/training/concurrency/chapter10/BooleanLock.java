package org.training.concurrency.chapter10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class BooleanLock implements Lock {
    // The initValue is true indicated the lock have been getted
    // The initValue is false indicated the lock is free (other thread can get this)
    private boolean initValue;

    private Collection<Thread> blockedThreadCollection = new ArrayList<>();

    private Thread currentThread;

    public BooleanLock() {
        this.initValue = false;
    }

    public BooleanLock(boolean initValue) {
        this.initValue = initValue;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        while (initValue) {
            blockedThreadCollection.add(Thread.currentThread());
            this.wait();
        }
        blockedThreadCollection.remove(Thread.currentThread());
        this.initValue = true;
        this.currentThread = Thread.currentThread();
    }

    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeOutException {
        if (mills < -0) {
            lock();
        }
        long hasRemaining = mills;
        long endTime = System.currentTimeMillis() + mills;
        while (initValue) {
            if (hasRemaining <= 0) {
                throw new TimeOutException("Time out");
            }
            blockedThreadCollection.add(Thread.currentThread());
//            this.wait(mills);
            this.wait(hasRemaining);
            hasRemaining = endTime - System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + ">>" + hasRemaining);
        }

        blockedThreadCollection.remove(Thread.currentThread());
        this.initValue = true;
        this.currentThread = Thread.currentThread();
    }

    @Override
    public synchronized void unlock() {
        if (Thread.currentThread() == currentThread) {
            this.initValue = false;
            Optional.of(Thread.currentThread().getName() + " release the lock monitor.").ifPresent(System.out::println);
            this.notify();
        }
    }

    @Override
    public Collection<Thread> getBlockedThread() {
        return Collections.unmodifiableCollection(blockedThreadCollection);
    }

    @Override
    public int getBlockedSize() {
        return blockedThreadCollection.size();
    }
}
