package org.training.concurrent2.chapter7;

public class ImmutablePerformance {
    public static void main(String[] args) {
        long startTimestamp = System.currentTimeMillis();
        SyncObj syncObj = new SyncObj();
        syncObj.setName("Alex");
        for (long l = 0L; l < 1_000_000; l++) {
            System.out.println(syncObj.toString());
        }
        long endTimeStamp = System.currentTimeMillis();
        System.out.println("Elapsed time " + (endTimeStamp - startTimestamp));
    }
}

final class ImmutableObj {
    private final String name;

    public ImmutableObj(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}

class SyncObj {
    private String name;

    public synchronized void setName(String name) {
        this.name = name;
    }

    @Override
    public synchronized String toString() {
        return "[" + name + "]";
    }
}