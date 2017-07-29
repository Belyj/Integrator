package ru.handbook.model.utilites.serialization.dom;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.model.storage.DataStorage;

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

        for (Contact contact : DataStorage.getInstance().getContacts()) {
            Element contactEl = document.createElement("Contact");
            Attr contactAttribute = document.createAttribute("name");
            contactAttribute.setValue(contact.getName());
            Element contacIdEl = document.createElement("id");
            contactEl.appendChild(contacIdEl).setTextContent(String.valueOf(contact.getId()));
            contactEl.setAttributeNode(contactAttribute);
            contactsEl.appendChild(contactEl);
        }

        for (Group group : DataStorage.getInstance().getGroups()) {
            Element groupEl = document.createElement("Group");
            Attr groupAttribute = document.createAttribute("name");
            groupAttribute.setValue(group.getName());
            Element groupIdEl = document.createElement("id");
            groupEl.appendChild(groupIdEl).setTextContent(String.valueOf(group.getId()));
            groupEl.setAttributeNode(groupAttribute);
            groupsEl.appendChild(groupEl);
            Element groupContacts = document.createElement("GroupContacts");
            groupEl.appendChild(groupContacts);
            for (Contact contact : group.getInner()) {
                Element contactEl = document.createElement("GroupContact");
                Attr contactAttribute = document.createAttribute("name");
                contactAttribute.setValue(contact.getName());
                Element contacIdEl = document.createElement("id");
                contactEl.appendChild(contacIdEl).setTextContent(String.valueOf(contact.getId()));
                contactEl.setAttributeNode(contactAttribute);
                groupContacts.appendChild(contactEl);
            }
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("dom.xml"));
        Transformer transformer = createTransformer(transformerFactory);
        try {
            transformer.transform(domSource, streamResult);
        } catch (TransformerException e) {
            System.out.println("Transforming failed");
        }
        System.out.println("Saved");
    }

    private Transformer createTransformer(TransformerFactory transformerFactory) {
        System.out.println("Creating transformer");
        try {
            return transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            System.out.println("Transormer creating error");
        }
        return null;
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
