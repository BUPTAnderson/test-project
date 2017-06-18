package org.training.observer;

/**
 * Created by anderson on 17-6-17.
 */
public class MySubject extends AbstractSubject
{
    @Override
    public void operation()
    {
        System.out.println("update self!");
        notifyObservers();
    }
}
