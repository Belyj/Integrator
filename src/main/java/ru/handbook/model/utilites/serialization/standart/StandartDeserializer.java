package ru.handbook.model.utilites.serialization.standart;

import ru.handbook.model.storage.DataStorage;

import java.io.*;

public class StandartDeserializer {
    public static void deSerialize() {
        ObjectInputStream objectInputStream = createOIS();
        try {
            if (new File("temp.out").exists()) {
                System.out.println("File founded");
                DataStorage serial = DataStorage.getInstance();
                serial = (DataStorage) objectInputStream.readObject();
                System.out.println("Read file success");
                return;
            }
        } catch (IOException e) {
            System.out.println("File for deserializing not found");
        } catch (ClassNotFoundException e) {
            System.out.println("Handbook have not component for reading file");
        } finally {
            if (new File("temp.out").exists()) {
                try {
                    objectInputStream.close();
                    return;
                } catch (IOException e) {
                    System.out.println("Inputstream didnot created");
                    return;
                }
            } else System.out.println("Inputstream didnot created");
        }
    }

    public static ObjectInputStream createOIS() {
        try {
            if (new File("temp.out").exists()) {
                System.out.println("Creating ObjectInputStream...");
                return new ObjectInputStream(createFIS());
            } else System.out.println("File does not exist");
        } catch (IOException e) {
            System.out.println("Creating ObjectInputStream failed");
        }
        return null;
    }

    public static FileInputStream createFIS() {
        try {
            System.out.println("Creating FileInputStream...");
            return new FileInputStream("temp.out");
        } catch (FileNotFoundException e) {
            System.out.println("Creating FileInputStream failed");
        }
        System.out.println("File not found");
        return null;
    }
}
