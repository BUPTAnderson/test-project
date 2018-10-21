package org.training.concurrent2.chapter4;

import java.util.Arrays;

public class ThreadLifeycleClient {
    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1", "2"));
    }
}
