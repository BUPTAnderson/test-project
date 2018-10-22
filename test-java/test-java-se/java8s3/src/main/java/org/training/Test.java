package org.training;

class Root{
    public Root() {
        System.out.println("Root的无参的构造器");
    }

    static {
        System.out.println("Root的静态初始化块");
    }

    public static String name = "root";
    public int age = 100;

    {
        System.out.println("Root的普通初始化块");
    }
}

class Mid extends Root {
    public Mid() {
        System.out.println("Mid的无参的构造器");
    }

    static {
        System.out.println("Mid的静态初始化块");
    }

    public static String midName = "mid";
    public int midAge = 20;

    {
        System.out.println("Mid的普通初始化块");
    }
}

class Leaf extends Mid{
    public Leaf() {
        System.out.println("Leaf的无参的构造器");
    }

    public static String leafName = "leaf";
    public int leafAge = 30;
    static {
        System.out.println("Leaf的静态初始化块");
    }

    {
        System.out.println("Leaf的普通初始化块");
    }
}

public class Test {
    public static void main(String[] args) {
//        new Leaf();
//        System.out.println("--------------------");
//        new Leaf();
        new Root();
    }
}
