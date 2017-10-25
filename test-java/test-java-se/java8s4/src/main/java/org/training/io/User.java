package org.training.io;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1234567891234567890L;
    private int age;
    // transient可以用来简单的控制某个字段不被序列化
    private transient String name;
//    private int num;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
