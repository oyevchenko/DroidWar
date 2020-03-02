package main.ua.javaextern.aleksandr.droidtask;

import main.ua.javaextern.aleksandr.droidtask.droid.Droid;

import java.io.*;

public class Serializator {
    private String destination = "src" + File.separator + "property"
            + File.separator + "serialized";
    void serialize(Droid droid) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(destination);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(droid);
        outputStream.close();
    }

    Droid deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(destination);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        return (Droid) inputStream.readObject();
    }
}


