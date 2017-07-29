package ru.handbook.model.utilites.serialization.dom;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMSerializer {

    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

    public DOMSerializer() {
        writeValue();
    }

    private void writeValue() {
        Document document = createDocument();
        Element rootEl = document.createElement("Objects");
        document.appendChild(rootEl);

        Element contactsEl = document.createElement("Contacts");
        rootEl.appendChild(contactsEl);

        Element groupsEl = document.createElement("Groups");
        rootEl.appendChild(groupsEl);

        Element contactEl = document.createElement("Contact");
        Attr contactAttribute = document.createAttribute("name");
        contactAttribute.setValue("A");
        contactEl.setAttributeNode(contactAttribute);
        contactsEl.appendChild(contactEl);

        Element groupEl = document.createElement("Group");
        Attr groupAttribute = document.createAttribute("name");
        groupAttribute.setValue("G");
        groupEl.setAttributeNode(groupAttribute);
        groupsEl.appendChild(groupEl);

        Element idEl = document.createElement("id");
        contactEl.appendChild(idEl);
        //contactEl.appendChild(idEl.appendChild(document.createAttribute("11")));
        groupEl.appendChild(idEl).setTextContent("21");
        //groupEl.appendChild(idEl.appendChild(document.createAttribute("21")));

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("dom.xml"));
            transformer.transform(domSource, streamResult);
            System.out.println("Saved");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }

    private Document createDocument() {
        return createDocBuilder().newDocument();
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
}
