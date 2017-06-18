package org.training.observer.original;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by anderson on 17-6-17.
 */
public class ObserverB implements Observer
{
    int stateB;

    public int getStateB()
    {
        return stateB;
    }

    public void setStateB(int stateB)
    {
        this.stateB = stateB;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        setStateB((int) arg);
    }
}
