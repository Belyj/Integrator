package ru.handbook.dao.parsersdao.dom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.utilites.idgenerator.IdGenerator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DOMContactDAOImpl implements ObjectDAO<Contact> {

    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = createDocumentBuilder();
    Document document;
    InputStream inputStream = createInputStream();
    XPathFactory xPathFactory = XPathFactory.newInstance();
    XPath xPath = xPathFactory.newXPath();
    NodeList nodeList;

    private FileInputStream createInputStream() {
        try {
            return new FileInputStream("contact.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void transform() {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        try {
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("contact.xml"));
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private DocumentBuilder createDocumentBuilder() {
        try {
            return documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Contact create(Contact contact) {
        if (document != null) {


            Node rootElement = document.getDocumentElement();
            if (rootElement == null) {
                rootElement = document.createElement("Contacts");
                document.appendChild(rootElement);
            }

            contact.setId(Integer.parseInt(new IdGenerator().generateContactId(getAll())));

            Element contactEl = document.createElement("Contact");
            Attr contactAttribute = document.createAttribute("name");
            contactAttribute.setValue(contact.getName());

            Element contacIdEl = document.createElement("id");
            contactEl.appendChild(contacIdEl).setTextContent(String.valueOf(contact.getId()));
            contactEl.setAttributeNode(contactAttribute);

            Element contacPhoneEl = document.createElement("phone");
            contactEl.appendChild(contacPhoneEl).setTextContent(String.valueOf(contact.getPhone()));
            contactEl.setAttributeNode(contactAttribute);

            Element contactSkype = document.createElement("skype");
            contactEl.appendChild(contactSkype).setTextContent(String.valueOf(contact.getSkype()));
            contactEl.setAttributeNode(contactAttribute);

            Element contactMail = document.createElement("mail");
            contactEl.appendChild(contactMail).setTextContent(String.valueOf(contact.getMail()));
            contactEl.setAttributeNode(contactAttribute);
            rootElement.appendChild(contactEl);
            transform();

            nodeList = document.getElementsByTagName("Contact");
            Contact createdContact = new Contact();
            createdContact.setName(contact.getName());

        }
        return contact;
    }

    @Override
    public Contact getByName(Contact contact) {
        nodeList = document.getElementsByTagName("Contact");
        for (int i = 1; i <= nodeList.getLength(); i++) {
            Element c = null;
            try {
                c = (Element) xPath.evaluate("Contacts/Contact[" + i + "]", document, XPathConstants.NODE);
            } catch (XPathExpressionException e) {
                System.out.println("XPath Error");
            }
            if (contact.getName().equals(c.getAttribute("name"))) {
                try {
                    contact.setId(Integer.parseInt(xPath.evaluate("Contacts/Contact[" + i + "]/id", document)));
                    contact.setPhone(Integer.parseInt(xPath.evaluate("Contacts/Contact[" + i + "]/phone", document)));

                    if (!xPath.evaluate("Contacts/Contact[" + i + "]/skype", document).isEmpty()) {
                        contact.setSkype(xPath.evaluate("Contacts/Contact[" + i + "]/skype", document));
                    } else contact.setSkype("");

                    if (!xPath.evaluate("Contacts/Contact[" + i + "]/mail", document).isEmpty()) {
                        contact.setMail(xPath.evaluate("Contacts/Contact[" + i + "]/mail", document));
                    } else contact.setMail("");
                } catch (XPathExpressionException e) {
                    System.out.println("XPath Error");
                }
                return contact;
            }
        }
        return null;
    }

    @Override
    public Contact update(Contact contact) {
        return null;
    }

    @Override
    public Contact delete(Contact contact) {
        nodeList = document.getElementsByTagName("Contact");
        Contact deletedContact;
        Element c = null;
        for (int i = 1; i <= nodeList.getLength(); i++) {
            try {
                c = (Element) xPath.evaluate("Contacts/Contact[" + i + "]", document, XPathConstants.NODE);
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }

            if (contact.getName().equals(c.getAttribute("name"))) {
                deletedContact = new Contact();
                try {
                    deletedContact.setId(Integer.parseInt(xPath.evaluate("Contacts/Contact[" + i + "]/id", document)));
                    deletedContact.setPhone(Integer.parseInt(xPath.evaluate("Contacts/Contact[" + i + "]/phone", document)));

                    if (!xPath.evaluate("Contacts/Contact[" + i + "]/skype", document).isEmpty()) {
                        deletedContact.setSkype(xPath.evaluate("Contacts/Contact[" + i + "]/skype", document));
                    } else deletedContact.setSkype("");

                    if (!xPath.evaluate("Contacts/Contact[" + i + "]/mail", document).isEmpty()) {
                        deletedContact.setMail(xPath.evaluate("Contacts/Contact[" + i + "]/mail", document));
                    } else deletedContact.setMail("");
                } catch (XPathExpressionException e) {
                    System.out.println("XPath Error");
                }
                document.getDocumentElement().removeChild(nodeList.item(i-1));
                transform();
                return contact;
            }
        }
        return null;
    }

    @Override
    public List<Contact> getAll() {
        try {
            document = documentBuilder.parse(inputStream);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Contact> contacts = new ArrayList();
        if (document != null) {
            nodeList = document.getElementsByTagName("Contact");
            Element c = null;
            for (int i = 1; i <= nodeList.getLength(); i++) {
                Contact contact = new Contact();
                try {
                    c = (Element) xPath.evaluate("Contacts/Contact[" + i + "]", document, XPathConstants.NODE);
                } catch (XPathExpressionException e) {
                    e.printStackTrace();
                }
                contact.setName(c.getAttribute("name"));
                try {
                    contact.setName(c.getAttribute("name"));
                    contact.setId(Integer.parseInt(xPath.evaluate("Contacts/Contact[" + i + "]/id", document)));
                    contact.setPhone(Integer.parseInt(xPath.evaluate("Contacts/Contact[" + i + "]/phone", document)));

                    if (!xPath.evaluate("Contacts/Contact[" + i + "]/skype", document).isEmpty()) {
                        contact.setSkype(xPath.evaluate("Contacts/Contact[" + i + "]/skype", document));
                    }
                    if (!xPath.evaluate("Contacts/Contact[" + i + "]/mail", document).isEmpty()) {
                        contact.setMail(xPath.evaluate("Contacts/Contact[" + i + "]/mail", document));
                    }
                } catch (XPathExpressionException e) {
                    e.printStackTrace();
                }
                contacts.add(contact);
            }
        }
        return contacts;
    }
}