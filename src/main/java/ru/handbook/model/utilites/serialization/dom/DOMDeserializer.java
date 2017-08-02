package ru.handbook.model.utilites.serialization.dom;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.model.storage.DataStorage;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class DOMDeserializer {

    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    Document document = createDocument();
    XPathFactory xPathFactory = XPathFactory.newInstance();
    XPath xPath = xPathFactory.newXPath();
    NodeList nodeList;

    public DOMDeserializer() {
        readValue();
    }

    private void readValue() {
        readContacts();
        readGroups();
    }

    private void readContacts() {
        if (document != null) {
            try {
                nodeList = document.getElementsByTagName("Contact");
                for (int i = 1; i <= nodeList.getLength(); i++) {
                    Element c = (Element) xPath.evaluate("Objects/Contacts/Contact[" + i + "]", document, XPathConstants.NODE);
                    Contact contact = new Contact();
                    contact.setName(c.getAttribute("name"));

                    contact.setId(Integer.parseInt(xPath.evaluate("Objects/Contacts/Contact[" + i + "]/id", document)));
                    contact.setPhone(Integer.parseInt(xPath.evaluate("Objects/Contacts/Contact[" + i + "]/phone", document)));
                    contact.setSkype(xPath.evaluate("Objects/Contacts/Contact[" + i + "]/skype", document));
                    contact.setMail(xPath.evaluate("Objects/Contacts/Contact[" + i + "]/mail", document));

                    DataStorage.getInstance().setContact(contact);
                }
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
        }
    }

    private void readGroups() {
        if (document != null) {
            nodeList = document.getElementsByTagName("Group");
            for (int i = 1; i <= nodeList.getLength(); i++) {
                try {
                    Element g = (Element) xPath.evaluate("Objects/Groups/Group[" + i + "]", document, XPathConstants.NODE);
                    Group group = new Group();
                    group.setName(g.getAttribute("name"));
                    group.setId(Integer.parseInt(xPath.evaluate("Objects/Groups/Group[" + i + "]/id", document)));

                    nodeList = document.getElementsByTagName("GroupContacts");

                    for (int j = 1; j <= nodeList.getLength(); j++) {
                        Element c = (Element) xPath.evaluate("Objects/Groups/Group[" + i + "]/GroupContacts/GroupContact[" + j + "]", document, XPathConstants.NODE);
                        Contact groupContact = new Contact();
                        groupContact.setName(c.getAttribute("name"));

                        groupContact.setId(Integer.parseInt(xPath.evaluate("Objects/Groups/Group[" + i + "]/GroupContacts/GroupContact[" + j + "]/id", document)));

                        groupContact.setPhone(Integer.parseInt(xPath.evaluate("Objects/Groups/Group[" + i + "]/GroupContacts/GroupContact[" + j + "]/phone", document)));

                        groupContact.setSkype(xPath.evaluate("Objects/Groups/Group[" + i + "]/GroupContacts/GroupContact[" + j + "]/skype", document));

                        groupContact.setMail(xPath.evaluate("Objects/Groups/Group[" + i + "]/GroupContacts/GroupContact[" + j + "]/mail", document));

                        group.getInner().add(groupContact);
                    }

                    DataStorage.getInstance().setGroup(group);
                } catch (XPathExpressionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private DocumentBuilder createDocBuilder() {
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            return documentBuilder;
        } catch (ParserConfigurationException e) {
            System.out.println("DocumentBuilder ошибка");
        }
        return null;
    }

    private Document createDocument() {
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
        return new File("dom.xml");
    }
}
