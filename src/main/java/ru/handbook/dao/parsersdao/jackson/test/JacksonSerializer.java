package ru.handbook.dao.parsersdao.jackson.test;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.storage.DataStorage;
import ru.handbook.view.contactview.Observer;

import java.io.*;

public class JacksonSerializer implements Observer {

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
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    @Override
    public void handleEvent() {
        writeValue();
    }
}