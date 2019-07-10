package org.training.other2;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Created by Anderson on 2018/12/13
 */
class Mobile {
    private String number;

    public Mobile() {
        this.number = "20161114";
    }

    public String toString() {
        return "[Mobile: " + number + "]";
    }
}

class Laptop {
    private String model;
    private String price;

    public Laptop() {
        this.model = "HP 20161119";
        this.price = "$1119";
    }

    public String toString() {
        return "[Laptop: " + model + "," + price + "]";
    }
}

class Person {
    private Mobile mobile;
    private Laptop laptop;

    @Inject
    public Person(Mobile mobile, Laptop laptop) {
        this.mobile = mobile;
        this.laptop = laptop;
    }

    public void displayInfo() {
        System.out.println("Mobile:" + mobile);
        System.out.println("Laptop:" + laptop);
    }
}

public class MultipleDependencyTest {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        Person person = injector.getInstance(Person.class);
        person.displayInfo();
    }
}
