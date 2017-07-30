package ru.handbook.model.utilites.serialization.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.model.storage.DataStorage;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMDeserializer {

    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

    public DOMDeserializer() {
        readValue();
    }

    private void readValue() {
        Document document = createDocument();

        NodeList nodeList = document.getElementsByTagName("Contact");
        int id = 0;

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element el = (Element) nodeList.item(i);
            id = Integer.parseInt(el.getElementsByTagName("id").item(0).getTextContent());
            Contact contact = new Contact();
            contact.setName(el.getAttribute("name"));
            contact.setId(id);
            DataStorage.getInstance().setContact(contact);
        }

        nodeList = document.getElementsByTagName("Group");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element el = (Element) nodeList.item(i);
            id = Integer.parseInt(el.getElementsByTagName("id").item(0).getTextContent());
            Group group = new Group();
            group.setName(el.getAttribute("name"));
            group.setId(id);
            NodeList contacts = el.getElementsByTagName("GroupContact");
            for (int j = 0; j < contacts.getLength(); j++) {
                Element contact = (Element) contacts.item(j);
                id = Integer.parseInt(contact.getFirstChild().getTextContent());
                Contact groupContact = new Contact();
                groupContact.setName(contact.getAttribute("name"));
                groupContact.setId(id);
                group.getInner().add(groupContact);
            }
            DataStorage.getInstance().setGroup(group);
        }
    }

    private DocumentBuilder createDocBuilder() {
        System.out.println("Creating docBuilder...");
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            return documentBuilder;
        } catch (ParserConfigurationException e) {
            System.out.println("DocumentBuilder ошибка");
        }
        return null;
    }

    private Document createDocument() {
        System.out.println("Creating document...");
        try {
            return createDocBuilder().parse(createFile());
        } catch (SAXException e) {
            System.out.println("creating Document SAX error");
        } catch (IOException e) {
            System.out.println("creating Document IO error");
        }
        return null;
    }

    private File createFile() {
        System.out.println("Creating file...");
        return new File("dom.xml");
    }
}
