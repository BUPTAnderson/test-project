package org.training.observer;

/**
 * Created by anderson on 17-6-17.
 */
public class Observer1 implements Observer
{
    @Override
    public void update()
    {
        System.out.println("observer1 has received!");
    }
}
