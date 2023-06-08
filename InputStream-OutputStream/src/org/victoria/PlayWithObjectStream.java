package org.victoria;

import org.victoria.model.User;

import java.io.*;

public class PlayWithObjectStream {

    /*
    - the process of taking an object from memory and writing it to a stream of bytes is called Serialization
    - only Serializable objects can be serialized
    - no method in Serializable
    - a Serializable class can define a serialVersionUID (a hash code of the class,
    it's used to deserialize the object)
    - deserializing an object may lead to partially reconstructed objects (missing fields will have default values)
     */
    public static void main(String[] args) {

        User u1 = new User("Paul", 23);
        User u2 = new User("Jennifer", 25);

        try (FileOutputStream fos = new FileOutputStream("files/users.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(u1);
            oos.writeObject(u2);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream("files/users.bin");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            User paul = (User) ois.readObject();
            User jennifer = (User) ois.readObject();

            System.out.println("jennifer = " + jennifer);
            System.out.println("paul = " + paul);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
