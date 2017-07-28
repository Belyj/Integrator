package ru.handbook.model.utilites.serialization.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.model.storage.DataStorage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class JacksonDeserializer {

    public JacksonDeserializer() {readValue();}

    private static void readValue() {
        DataStorage dataStorage = DataStorage.getInstance();
        XmlMapper mapper = new XmlMapper();
        FileInputStream fileInputStream = createFIS();
        //TypeReference<List<Contact>> contacts = dataStorage.getContacts();
        if (fileInputStream != null) {
            try {
                dataStorage.getContacts().add(mapper.readValue(fileInputStream, Contact.class));
                //dataStorage.getGroups().add(mapper.readValue(fileInputStream, Group.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else System.out.println("FIS is null");
    }

    public static FileInputStream createFIS() {
        try {
            System.out.println("Creating FileInputStream...");
            return new FileInputStream("jackson.xml");
        } catch (FileNotFoundException e) {
            System.out.println("Creating FileInputStream failed");
        }
        System.out.println("File not found");
        return null;
    }
}
