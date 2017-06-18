package org.training.observer.original;

import java.util.Observable;

/**
 * Created by anderson on 17-6-17.
 * 利用java原生的类来实现观察者模式
 */
public class ConcreteSubject extends Observable
{
    private int state;

    public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state; // 目标对象发生了改变
        setChanged();   // 表示目标对象已经做了更改
        notifyObservers(state); // 通知观察者
        // 如果state不传入, 调用的是无参方法(如下), 则观察者的update方法中需要使用Observable来获取状态
//        notifyObservers(); // 通知观察者
    }
}
