package ru.handbook.model.utilites.serialization.jackson;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.model.storage.DataStorage;

import java.io.*;

public class JacksonSerializer {

    public JacksonSerializer() {
        writeValue();
    }

    private void writeValue() {
        DataStorage dataStorage = DataStorage.getInstance();
        XmlMapper mapper = new XmlMapper();
        FileOutputStream fileInputStream = createFOS();
        try {
            for (Contact contact : dataStorage.getContacts()) {
                mapper.writeValue(fileInputStream, contact);
                System.out.println(mapper.writeValueAsString(contact));
            }
//            for (Group group : dataStorage.getGroups()) {
//                mapper.writeValue(fileInputStream, group);
//                System.out.println(mapper.writeValueAsString(group));
//            }
        } catch (IOException e) {
            e.printStackTrace();
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
            return new FileOutputStream("jackson.xml");
        } catch (FileNotFoundException e) {
            createFile();
        }
        System.out.println("File not found");
        return null;
    }


    private static File createFile() {
        String path = new File("").getAbsolutePath();
        System.out.println("Creating file for serialization...");
        File file = new File(path + "jackson.xml");
        return file;
    }
}
