package org.training.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerialDemo {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setAge(23);
        user.setName("Tom");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.serial"));
        oos.writeObject(user);
        oos.close();

//        Person person = new Person();
//        person.setAge(20);
//        person.setName("Andy");
//        person.setCity("beijing");
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.serial"));
//        oos.writeObject(person);
//        oos.close();
    }
}
