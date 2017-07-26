package ru.handbook.model.utilites.serialization.standart;

import ru.handbook.model.storage.DataStorage;

import java.io.*;

public class StandartSerializer {
    public static void serialize() {
        ObjectOutputStream objectOutputStream = createOOS();
        try {
            objectOutputStream.writeObject(DataStorage.getInstance());
            System.out.println("Serializing is success");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                System.out.println("OutputStream was not created");
            }
        }
    }

    private static ObjectOutputStream createOOS() {
        try {
            System.out.println("Creating ObjectOutputStream...");
            return new ObjectOutputStream(createFOS());
        } catch (IOException e) {
            createFile();
        }
        return null;
    }

    private static FileOutputStream createFOS() {
        try {
            System.out.println("Creating FileOutputStream...");
            return new FileOutputStream("temp.out");
        } catch (FileNotFoundException e) {
            createFile();
        }
        System.out.println("File not found");
        return null;
    }


    private static File createFile() {
        String path = new File("").getAbsolutePath();
        System.out.println("Creating file for serialization...");
        File file = new File(path + "temp.out");
        return file;
    }
}
