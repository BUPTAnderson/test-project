package org.training.generics;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anderson on 16-8-29.
 */

interface InterGenerics2<T> {
    void setT(T t);
    T getT();
}

class InterGenerics2Demo<T> implements InterGenerics2 {
    @Override
    public void setT(Object o) {
    }

    @Override
    public Object getT() {
        return null;
    }
}

interface InterGenerics<T extends Number> {
//    void setT(T t);
//    T getT();
}
//class Generics<T> implements InterGenerics<T> {}  //错误
//class Generics<T extends Number> implements InterGenerics<T extends Number> {}    //错误
//class Generics<T> implements InterGenerics<T extends Number> {}   //错误
//class Generics implements InterGenerics<T extends Number> {}    //错误

class InterGenericsDemo02<S> implements InterGenerics{//正确InterGenerics的默认类型实参是Number
//    @Override
//    public void setT(Number number) {
//    }
//
//    @Override
//    public Number getT() {
//        return null;
//    }
}

//class InterGenericsDemo01 implements InterGenerics{
//}
//class InterGenericsDemo03<T, S> implements InterGenerics{
//}
//class InterGenericsDemo04<T extends Serializable> implements InterGenerics{
//}
//class InterGenericsDemo06<T extends Number> implements InterGenerics<T>{
//}
//class InterGenericsDemo08<T extends Number, S> implements InterGenerics<T>{
//}

class InterGenericsDemo09 implements InterGenerics<Integer> {
}

class InterGenericsDemo10<T extends Number> implements InterGenerics<Number> {
}

class InterGenericsDemo11<T> implements InterGenerics<Number> {
}

class InterGenericsDemo12<T, S> implements InterGenerics<Number> {
}

class InterGenericsDemo13<T extends Number> implements InterGenerics<T> {
}

class InterGenerics2Demo2 implements InterGenerics2<String> {
    @Override
    public void setT(String s) {
    }

    @Override
    public String getT() {
        return null;
    }
}

public class Test {
    private String getHostName() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            String hostName = inetAddress.getHostName();
            return hostName;
        } catch (UnknownHostException e) {
            System.out.println("unknown host!");
            return null;
        }
    }
    public static void main(String[] args) {
//        InterGenericsDemo06<Integer> demo06 = new InterGenericsDemo06<>();
//        InterGenericsDemo02<String> demo02 = new InterGenericsDemo02<>();
//        InterGenerics2Demo2<String> demo22 = new InterGenerics2Demo2<>();
//        System.out.println("abc".equals(null));
        Test test = new Test();
        System.out.println("anderson-JD".equals(test.getHostName()));

        List<?>[] lsa = new List<?>[10]; // OK, array of unbounded wildcard type.
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        oa[1] = li; // Correct.
        String s = (String) lsa[1].get(0); // Run time error, but cast is explicit.
    }
}
