package ru.handbook.model.utilites.serialization.sax;

import org.xml.sax.SAXException;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.model.storage.DataStorage;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SAXDeserializer {

    SAXParserFactory parserFactory = SAXParserFactory.newInstance();
    SAXParser saxParser = createSAXParser();
    ContactHandler contactHandler = new ContactHandler();
    GroupHandler groupHandler = new GroupHandler();
    GroupContactHandler groupContactHandler = new GroupContactHandler();
    public SAXDeserializer() {
        readValue();
    }

    private void readValue() {
        try {
            saxParser.parse(createFile(), contactHandler);
            saxParser.parse(createFile(), groupHandler);
            saxParser.parse(createFile(), groupContactHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 3; i++) {

        }
        Map<String, Integer> contactData = contactHandler.getData();

        for (Map.Entry<String, Integer> dMap : contactData.entrySet()) {
            createContact(dMap);
        }

        Map<String, Integer> groupData = groupHandler.getData();

        for (Map.Entry<String, Integer> dMap : groupData.entrySet()) {
            createGroup(dMap);
        }
    }

    private File createFile() {
        return new File("dom.xml");
    }

    private void createContact(Map.Entry<String, Integer> dMap) {
        Contact contact = new Contact();
        contact.setName(dMap.getKey());
        contact.setId(dMap.getValue());
        DataStorage.getInstance().setContact(contact);
    }

    private void createGroup(Map.Entry<String, Integer> dMap) {
        Group group = new Group();
        group.setName(dMap.getKey());
        group.setId(dMap.getValue());
        DataStorage.getInstance().setGroup(group);

        Map<String, Integer> groupContactData = groupContactHandler.getData();

        for (Map.Entry<String, Integer> gCMap : groupContactData.entrySet()) {
            group.getInner().add(createGroupContact(gCMap));
        }
    }

    private Contact createGroupContact(Map.Entry<String, Integer> gcMap) {
        Contact contact = new Contact();
        contact.setName(gcMap.getKey());
        contact.setId(gcMap.getValue());
        return contact;
    }

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
}
