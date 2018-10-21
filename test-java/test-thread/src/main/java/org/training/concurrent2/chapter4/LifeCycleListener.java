package org.training.concurrent2.chapter4;

public interface LifeCycleListener {
    void onEvent(ObservableRunnable.RunnableEvent event);
}
