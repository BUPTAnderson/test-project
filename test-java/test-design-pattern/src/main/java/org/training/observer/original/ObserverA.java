package org.training.observer.original;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by anderson on 17-6-17.
 */
public class ObserverA implements Observer
{
    private int stateA;

    public int getStateA()
    {
        return stateA;
    }

    public void setStateA(int stateA)
    {
        this.stateA = stateA;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        // 如果参数传入了, 即arg是不为null, 可以通过arg来传递状态, 如果arg为空, 则需要使用Observable获取状态,
        setStateA((int) arg);
        // 或者用下面的方法
//        setStateA(((ConcreteSubject) o).getState());
    }
}
