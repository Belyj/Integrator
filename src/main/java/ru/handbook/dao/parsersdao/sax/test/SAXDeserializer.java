package ru.handbook.dao.parsersdao.sax.test;

import org.xml.sax.SAXException;
import ru.handbook.dao.parsersdao.sax.ContactHandler;
import ru.handbook.dao.parsersdao.sax.GroupHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXDeserializer {

    SAXParserFactory parserFactory = SAXParserFactory.newInstance();
    SAXParser saxParser = createSAXParser();
    ContactHandler contactHandler = new ContactHandler();
    GroupHandler groupHandler = new GroupHandler();
    public SAXDeserializer() {
        readValue();
    }

    private void readValue() {
        try {
            saxParser.parse(createFile(), contactHandler);
            saxParser.parse(createFile(), groupHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File createFile() {
        return new File("dom.xml");
    }

//    private void createContact(Map.Entry<String, Integer> dMap) {
//        Contact contact = new Contact();
//        contact.setName(dMap.getKey());
//        contact.setId(dMap.getValue());
//        DataStorage.getInstance().setContact(contact);
//    }
//
//    private void createGroup(Map.Entry<String, Integer> dMap) {
//        Group group = new Group();
//        group.setName(dMap.getKey());
//        group.setId(dMap.getValue());
//        DataStorage.getInstance().setGroup(group);
//    }

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
