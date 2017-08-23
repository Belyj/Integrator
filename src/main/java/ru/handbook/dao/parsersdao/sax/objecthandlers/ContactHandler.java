package ru.handbook.dao.parsersdao.sax.objecthandlers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.handbook.model.objects.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactHandler extends DefaultHandler {

    //DataStorage dataStorage = DataStorage.getInstance();
    List<Contact> contacts = new ArrayList();
    Contact contact;
    Boolean isContact;
    private String name;
    private String element;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        element = qName;
        if (element.equals("Contact")) {
            isContact = true;
            contact = new Contact();
            name = attributes.getValue(0);
            contact.setName(name);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isContact) {
            //dataStorage.getContacts().add(contact);
            contacts.add(contact);
            isContact = false;
        }
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
                String phone = new String(ch, start, length);
                contact.setPhone(phone);
            }
        }
        if (element.equals("skype")) {
            if (name != null && !name.isEmpty()) {
                String skype = new String(ch, start, length);
                contact.setSkype(skype);
            }
        }
        if (element.equals("mail")) {
            if (name != null && !name.isEmpty()) {
                String mail = new String(ch, start, length);
                contact.setMail(mail);
            }
        }
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
