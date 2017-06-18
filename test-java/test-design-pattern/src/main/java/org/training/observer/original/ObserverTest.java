package org.training.observer.original;

/**
 * Created by anderson on 17-6-17.
 */
public class ObserverTest
{
    public static void main(String[] args)
    {
        // 创建目标对象
        ConcreteSubject concreteSubject = new ConcreteSubject();
        // 创建观察者
        ObserverA a = new ObserverA();
        ObserverB b = new ObserverB();
        // 将观察者添加到目标对象的容器中
        concreteSubject.addObserver(a);
        concreteSubject.addObserver(b);
        // 更改状态
        concreteSubject.setState(100);

        // 查看观察者的状态
        System.out.println(a.getStateA());
        System.out.println(b.getStateB());

        System.out.println("----------分割线-----------");

        // 再次更改状态
        concreteSubject.setState(99);
        // 查看观察者的状态
        System.out.println(a.getStateA());
        System.out.println(b.getStateB());
    }
}
