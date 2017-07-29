package ru.handbook.model.utilites.serialization.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
        Element element = document.getDocumentElement();
        String titleE1 = element.getNodeName();
        System.out.println("Title: " + titleE1);

        NodeList nodeList = document.getElementsByTagName("Contact");
        int id = 0;

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element el = (Element) nodeList.item(i);
            id = Integer.parseInt(el.getElementsByTagName("id").item(0).getTextContent());
            System.out.println(el.getAttribute("name"));
            System.out.println(id);
        }

        nodeList = document.getElementsByTagName("Group");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element el = (Element) nodeList.item(i);
            id = Integer.parseInt(el.getElementsByTagName("id").item(0).getTextContent());
            System.out.println(el.getAttribute("name"));
            System.out.println(id);
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
        return new File("jackson.xml");
    }
}
