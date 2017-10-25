package org.training.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserialDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.serial"));
        User user = (User) ois.readObject();
        System.out.println(user.getAge() + ", " + user.getName());

//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.serial"));
//        Person person = (Person) ois.readObject();
//        System.out.println(person.getAge() + ", " + person.getName() + ", " + person.getCity());
    }
}
