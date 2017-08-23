package ru.handbook.dao.parsersdao.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.utilites.validator.XMLValidator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class JacksonContactDAOImpl implements ObjectDAO<Contact> {

    ObjectMapper mapper = new XmlMapper();
    FileInputStream fileInputStream;
    List<Contact> contacts;

    public JacksonContactDAOImpl() {
        if (new XMLValidator().validateXMLSchema("src/main/java/ru/handbook/model/utilites/validator/xsd/ContactSchema.xsd", "contact.xml")) {
            System.out.println("Validate is ok");
        } else System.out.println("Validate error");
    }

    public static FileInputStream createFIS() {
        if (!new File("contact.xml").exists()) {
            String path = new File("").getAbsolutePath();
            new File(path, "contact.xml");
        }
        try {
            return new FileInputStream("contact.xml");
        } catch (FileNotFoundException e) {
            System.out.println("Creating FileInputStream failed");
        }
        System.out.println("File not found");
        return null;
    }

    public static File createFile() {
        return new File("contact.xml");
    }

    @Override
    public Contact create(Contact contact) {
        return null;
    }

    @Override
    public Contact getByName(Contact contact) {
        return null;
    }

    @Override
    public Contact update(Contact contact) {
        return null;
    }

    @Override
    public Contact delete(Contact contact) {
        return null;
    }

    @Override
    public List<Contact> getAll() {
        try {
            contacts.add(mapper.readValue(createFIS(), Contact.class));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return contacts;
    }
}
