package org.training.reflection2.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by kongyunlong on 2016/6/10.
 */
interface Human{
    void info();
    void fly();
}

//被代理类
class SuperMan implements Human{
    @Override
    public void info() {
        System.out.println("我是超人！我怕谁！");
    }

    @Override
    public void fly() {
        System.out.println("I believe I can fly!");
    }
}

class HumanUtil{
    public void method1() {
        System.out.println("=========== 方法一 ===========");
    }
    public void method2() {
        System.out.println("=========== 方法二 ===========");
    }
}

class MyInvocationHandler implements InvocationHandler {
    Object obj;
    public void setObject(Object obj) {
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil h = new HumanUtil();
        h.method1();
        Object returnVal = method.invoke(obj, args);
        h.method2();
        return null;
    }
}

//动态的创建一个代理类的对象
class MyProxy{
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.setObject(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

public class TestAOP {
    public static void main(String[] args) {
        SuperMan man = new SuperMan();  //创建被代理类对象
        Object obj = MyProxy.getProxyInstance(man);  //返回一个代理类的对象
        Human hu = (Human) obj;
        hu.info();     //通过代理类的对象调用重写的抽象方法。
        System.out.println();
        hu.fly();
        System.out.println("------------------");
        NikeClothFactory nike = new NikeClothFactory();
        Object obj1 = MyProxy.getProxyInstance(nike);
        ClothFactory cloth = (ClothFactory) obj1;
        cloth.productCloth();
    }
}
