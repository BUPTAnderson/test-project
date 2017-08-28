package org.training.reflection2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by kongyunlong on 2016/6/10.
 */
//动态代理的使用
interface Subject
{
    void action();
}

//被代理类
class RealSubject
        implements Subject
{
    @Override
    public void action()
    {
        System.out.println("我是被代理类，记得要执行我哦！么么~~");
    }
}

class MyInvocationHandler
        implements InvocationHandler
{
    Object obj; //实现了接口的被代理类的对象的声明

    //①给被代理类的对象实例化
    //②返回一个代理类的对象
    public Object blind(Object obj)
    {
        this.obj = obj;
        //三个参数：与obj的类加载器一样，实现的接口为obj实现的接口，InvocationHandler实例为调用当前该方法的实例本身。
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), this);
    }

    //当通过代理类的对象发起对被重写的方法的调用时，都会转化为对如下的invoke方法的调用。
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable
    {
        //method方法的返回值是returnVal
        System.out.println("invoke方法");
        System.out.println(obj.getClass().getName() + " " + proxy.getClass().getName());
        Object returnVal = method.invoke(obj, args);
        return returnVal;
    }
}

public class TestProxy
{
    public static void main(String[] args)
    {
        //1.被代理类的对象
        RealSubject real = new RealSubject();
        //创建一个实现了 InvocationHandler接口的类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        //调用blind()方法，动态的返回一个同样实现了real所在类实现的接口Subject的代理类的对象。
        Object obj = handler.blind(real);
        Subject sub = (Subject) obj;  //此时的sub就是代理类的对象

        sub.action();   //该方法执行会转到 InvocationHandler接口的实现类的invoke()方法的调用。

        //再举一例
        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory proxyCloth = (ClothFactory) handler.blind(nike); //proxyCloth即为代理类的对象
        proxyCloth.productCloth();
    }
}
