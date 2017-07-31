package ru.handbook.model.utilites.serialization.jackson;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.storage.DataStorage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JacksonDeserializer {

    public JacksonDeserializer() {readValue();}

    private static void readValue() {
        DataStorage dataStorage = DataStorage.getInstance();
        XmlMapper mapper = new XmlMapper();
        FileInputStream fileInputStream = createFIS();
        if (fileInputStream != null) {

            try {
                dataStorage.getContacts().add(mapper.readValue(fileInputStream, Contact.class));
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
}
