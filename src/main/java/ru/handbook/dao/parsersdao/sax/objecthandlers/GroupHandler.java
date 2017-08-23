package ru.handbook.dao.parsersdao.sax.objecthandlers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupHandler extends DefaultHandler {

    private List<Contact> contacts;
    private List<Group> groups = new ArrayList();
    private Contact contact;
    private Group group;
    private boolean isIdGroup;
    private boolean isGroup;
    private boolean isConact;
    private boolean isGroupContact;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isIdGroup) {
            group.setId(Integer.parseInt(new String(ch, start, length).trim()));
            isIdGroup = false;
        } else if (isConact) {
            contact.setId(Integer.parseInt(new String(ch, start, length).trim()));
            contacts.add(contact);
        }
        super.characters(ch, start, length);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("Group".equalsIgnoreCase(qName)) {
            group = new Group();
            group.setName(attributes.getValue("name"));
            isGroup = true;
        } else if ("GroupContacts".equalsIgnoreCase(qName)) {
            contacts = new ArrayList();
            isGroupContact = true;
        } else if ("id".equalsIgnoreCase(qName) && isGroup) {
            isIdGroup = true;
        } else if ("ContactID".equalsIgnoreCase(qName)) {
            contact = new Contact();
            isConact = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("GroupContacts".equalsIgnoreCase(qName)) {
            group.setInner(contacts);
        } else if ("GroupContact".equalsIgnoreCase(qName)) {
            contacts.add(contact);
        } else if ("Group".equalsIgnoreCase(qName)) {
            groups.add(group);
            isGroup = false;
        }
    }

    public List<Group> getGroups() {
        return groups;
    }
}
