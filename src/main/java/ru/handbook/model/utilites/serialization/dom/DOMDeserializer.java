package ru.handbook.model.utilites.serialization.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.storage.DataStorage;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMDeserializer {

    public DOMDeserializer() {
        readValue();
    }

    private void readValue() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        Document document;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse("jackson.xml");
            DataStorage dataStorage = DataStorage.getInstance();
            Contact contact = new Contact();
            Element element = document.getDocumentElement();
            NodeList nodeList = document.getElementsByTagName("Contact");
            //System.out.println("id");
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println(element.getAttribute("name"));
                System.out.println(element.getElementsByTagName("id").item(0).getChildNodes());
            }

            dataStorage.getContacts().add(contact);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
