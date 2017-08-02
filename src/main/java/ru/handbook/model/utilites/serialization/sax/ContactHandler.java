package ru.handbook.model.utilites.serialization.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.storage.DataStorage;

import java.util.HashMap;
import java.util.Map;

public class ContactHandler extends DefaultHandler {

    DataStorage dataStorage = DataStorage.getInstance();
    Contact contact;
    private String name;
    private String element;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        element = qName;
        if (element.equals("Contact")) {
            contact = new Contact();
            contact.setName(attributes.getValue(0));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        dataStorage.getContacts().add(contact);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (element.equals("id")) {
            if (name != null && !name.isEmpty()) {
                int id = Integer.parseInt(new String(ch, start, length));
                contact.setId(id);
            }
        }
        if (element.equals("phone")) {
            if (name != null && !name.isEmpty()) {
                int phone = Integer.parseInt(new String(ch, start, length));
                contact.setPhone(phone);
            }
        }
        if (element.equals("skype")) {
            if (name != null && !name.isEmpty()) {
                String skype = new String(ch, start, length);
                contact.setSkype(skype);
            }
        }
        if (element.equals("skype")) {
            if (name != null && !name.isEmpty()) {
                String mail = new String(ch, start, length);
                contact.setMail(mail);
            }
        }
    }
}
