package org.training.reflection2;

/**
 * Created by kongyunlong on 2016/6/10.
 */
//接口的应用，代理模式
interface ObjectClass{
    void action();
}

//代理类
class ProxyObject implements ObjectClass{
    ObjectClass obj;
    public ProxyObject(ObjectClass obj) {
        System.out.println("代理类创建成功");
        this.obj = obj;
    }

    @Override
    public void action() {
        System.out.println("代理类开始执行......");
        obj.action();
        System.out.println("代理类执行结束......");
    }
}

//被代理类
class ObjectImpl implements ObjectClass{
    @Override
    public void action() {
        System.out.println("被代理类开始执行......");
        System.out.println("具体操作......");
        System.out.println("被代理类执行完毕......");
    }
}

public class TestStaticProxy {
    public static void main(String[] args) {
        ObjectClass obj = new ProxyObject(new ObjectImpl());
        obj.action();
    }
}
