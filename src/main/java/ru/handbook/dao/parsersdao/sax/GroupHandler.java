package ru.handbook.dao.parsersdao.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.model.storage.DataStorage;

import java.util.ArrayList;
import java.util.List;

public class GroupHandler extends DefaultHandler {

    DataStorage dataStorage = DataStorage.getInstance();
    private List<Contact> contacts;
    private Contact contact;
    private Group group;
    private boolean isIdGroup;
    private boolean isGroup;
    private boolean isGroupContact;
    private boolean isIdContact;
    private boolean isPhoneContact;
    private boolean isSkypeContact;
    private boolean isMailContact;
    private boolean isGroups;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isIdGroup) {
            group.setId(Integer.parseInt(new String(ch, start, length).trim()));
            isIdGroup = false;
        } else if (isIdContact) {
            contact.setId(Integer.parseInt(new String(ch, start, length).trim()));
            isIdContact = false;
        } else  if(isPhoneContact) {
            contact.setPhone(Integer.parseInt(new String(ch, start, length).trim()));
            isPhoneContact = false;
        } else if (isSkypeContact) {
            contact.setSkype(new String(ch, start, length).trim());
            isSkypeContact = false;
        } else if (isMailContact) {
            contact.setMail(new String(ch, start, length).trim());
            isMailContact = false;
        }
        super.characters(ch, start, length);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("Groups".equalsIgnoreCase(qName)) {
            isGroups = true;
        } else if ("Group".equalsIgnoreCase(qName)) {
            group = new Group();
            group.setName(attributes.getValue("name"));
            isGroup = true;
        } else if("GroupContacts".equalsIgnoreCase(qName)){
            contacts = new ArrayList();
        }
        else if ("id".equalsIgnoreCase(qName) && isGroup && isGroups) {
            isIdGroup = true;
        } else if ("GroupContact".equalsIgnoreCase(qName)) {
            isGroup = false;
            contact = new Contact();
            contact.setName(attributes.getValue("name"));
            isGroupContact = true;
        } else if ("id".equalsIgnoreCase(qName) && isGroupContact) {
            isIdContact = true;
        } else if ("phone".equalsIgnoreCase(qName) && isGroupContact) {
            isPhoneContact = true;
        } else if ("skype".equalsIgnoreCase(qName) && isGroupContact) {
            isSkypeContact = true;
        } else if ("mail".equalsIgnoreCase(qName) && isGroupContact) {
            isMailContact = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("GroupContacts".equalsIgnoreCase(qName)) {
            group.setInner(contacts);
        } else if ("GroupContact".equalsIgnoreCase(qName)) {
            contacts.add(contact);
        } else if ("Group".equalsIgnoreCase(qName)) {
            dataStorage.getGroups().add(group);
            isGroup = false;
        }
    }
}
