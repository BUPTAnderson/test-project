package org.training.observer;

/**
 * Created by anderson on 17-6-17.
 */
public class ObserverTest
{
    public static void main(String[] args)
    {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());

        sub.operation();
    }
}
