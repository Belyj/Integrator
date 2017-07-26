package ru.handbook.model.utilites.serialization.jackson;

import org.codehaus.jackson.map.ObjectMapper;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.storage.DataStorage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JacksonSerializer {

    public JacksonSerializer() {
        writeValue();
    }

    private void writeValue() {
        DataStorage dataStorage = DataStorage.getInstance();
        ObjectMapper mapper = new ObjectMapper();
        try {
            for (Contact contact : dataStorage.getContacts()) {
                mapper.writeValue(new FileOutputStream(System.getProperty("user.dir") + File.separator + "temp.json"), contact);
                System.out.println(mapper.writeValueAsString(contact));
            }
        } catch (IOException ex) {
            Logger.getLogger(JacksonSerializer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
