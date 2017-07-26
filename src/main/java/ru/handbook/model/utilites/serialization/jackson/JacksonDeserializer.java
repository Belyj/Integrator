package ru.handbook.model.utilites.serialization.jackson;

import org.codehaus.jackson.map.ObjectMapper;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.storage.DataStorage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JacksonDeserializer {
    public static void main(String[] args) {
        readValue();
    }

    private static void readValue() {
        DataStorage dataStorage = DataStorage.getInstance();
        String filepath = System.getProperty("user.dir") + File.separator + "temp.json";
        ObjectMapper mapper = new ObjectMapper();
        try {
            for (Contact contact : dataStorage.getContacts()) {
                contact = (Contact) mapper.readValue(new FileInputStream(filepath), Contact.class);
                System.out.println(contact);
            }
        } catch (IOException ex) {
            Logger.getLogger(JacksonDeserializer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
