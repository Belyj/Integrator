package ru.handbook.dao.parsersdao.sax;

import org.xml.sax.SAXException;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.dao.parsersdao.sax.objecthandlers.ContactHandler;
import ru.handbook.model.objects.Contact;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SAXContactDAOImpl implements ObjectDAO<Contact> {

    SAXParserFactory parserFactory = SAXParserFactory.newInstance();
    SAXParser saxParser = createSAXParser();
    ContactHandler contactHandler = new ContactHandler();

    private SAXParser createSAXParser() {
        try {
            return parserFactory.newSAXParser();
        } catch (ParserConfigurationException e) {
            System.out.println("Pareser configuration error");
        } catch (SAXException e) {
            e.toString();
        }
        return null;
    }

    private File createFile() {
        return new File("contact.xml");
    }

    @Override
    public Contact create(Contact contact) {
        return null;
    }

    @Override
    public Contact getByName(Contact contact) {
        List<Contact> contacts;
        try {
            InputStream inputStream = new FileInputStream("contact.xml");
            try {
                saxParser.parse(inputStream, contactHandler);
                contacts = contactHandler.getContacts();
                for (Contact c : contacts) {
                    if (c.getName().equals(contact.getName())) {
                        return c;
                    }
                }
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
        return contactHandler.getContacts();
    }
}
