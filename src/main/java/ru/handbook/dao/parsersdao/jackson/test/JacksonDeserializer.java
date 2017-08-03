package ru.handbook.dao.parsersdao.jackson.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.handbook.dao.parsersdao.jackson.objects.Contacts;
import ru.handbook.model.storage.DataStorage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JacksonDeserializer {

    public JacksonDeserializer() {readValue();}

    private static void readValue() {
        DataStorage dataStorage = DataStorage.getInstance();
        ObjectMapper mapper = new XmlMapper();
        FileInputStream fileInputStream = createFIS();
        Contacts contacts;
        if (fileInputStream != null) {

            try {
                //jacksonContacts.setContacts(mapper.readValues(fileInputStream, JacksonContacts.class));
                contacts = mapper.readValue(createFile(), Contacts.class);
                //jacksonContacts.setContacts(mapper.readValues(createFile(), JacksonContacts.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else System.out.println("FIS is null");
    }

    public static FileInputStream createFIS() {
        try {
            return new FileInputStream("jackson.xml");
        } catch (FileNotFoundException e) {
            System.out.println("Creating FileInputStream failed");
        }
        System.out.println("File not found");
        return null;
    }

    public static File createFile() {
        return new File("jackson.xml");
    }
}
