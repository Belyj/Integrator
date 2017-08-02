package ru.handbook.dao.parsersdao.dom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import ru.handbook.dao.parsersdao.ObjectParserDAO;
import ru.handbook.model.objects.Contact;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DOMContactDAOImpl implements ObjectParserDAO<Contact> {

    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    Document document = createDocument();
    Scanner scanner = new Scanner(System.in);
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    DOMSource domSource = new DOMSource(document);
    StreamResult streamResult = new StreamResult(new File("dom.xml"));
    Transformer transformer = createTransformer(transformerFactory);

    XPathFactory xPathFactory = XPathFactory.newInstance();
    XPath xPath = xPathFactory.newXPath();
    NodeList nodeList;

    private Document createDoc() {
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
            try {
                document = createDocBuilder().parse("dom.xml");
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return document;
    }

    private void transform() {
        try {
            transformer.transform(domSource, streamResult);
        } catch (TransformerException e) {
            System.out.println("Transform failed");
        }
    }

    private Transformer createTransformer(TransformerFactory transformerFactory) {
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
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            return documentBuilder;
        } catch (ParserConfigurationException e) {
            System.out.println("DocumentBuilder ошибка");
        }
        return null;
    }

    @Override
    public Contact create(Contact contact) {
        Node rootElement = document.getDocumentElement();

        if (rootElement == null) {
            rootElement = document.createElement("Contacts");
            document.appendChild(rootElement);
        }

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
        for (int i = 1; i <= nodeList.getLength(); i++) {
            Element c = null;
            try {
                c = (Element) xPath.evaluate("Contacts/Contact[" + i + "]", document, XPathConstants.NODE);
            } catch (XPathExpressionException e) {
                System.out.println("XPath Error");
            }
            if (contact.getName().equals(c.getAttribute("name"))) {
                try {
                    createdContact.setId(Integer.parseInt(xPath.evaluate("Contacts/Contact[" + i + "]/id", document)));
                    createdContact.setPhone(Integer.parseInt(xPath.evaluate("Contacts/Contact[" + i + "]/phone", document)));

                    if (!xPath.evaluate("Contacts/Contact[" + i + "]/skype", document).isEmpty()) {
                        createdContact.setSkype(xPath.evaluate("Contacts/Contact[" + i + "]/skype", document));
                    } else createdContact.setSkype("");

                    if (!xPath.evaluate("Contacts/Contact[" + i + "]/mail", document).isEmpty()) {
                        createdContact.setMail(xPath.evaluate("Contacts/Contact[" + i + "]/mail", document));
                    } else createdContact.setMail("");
                } catch (XPathExpressionException e) {
                    System.out.println("XPath Error");
                }
            }
        }
        return createdContact;
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
        String name = contact.getName();
        nodeList = document.getElementsByTagName("Contact");

        for (int i = 1; i <= nodeList.getLength(); i++) {
            Element c = null;
            try {
                c = (Element) xPath.evaluate("Contacts/Contact[" + i + "]", document, XPathConstants.NODE);
            } catch (XPathExpressionException e) {
                System.out.println("XPath Error");
            }

            if (name.equals(c.getAttribute("name"))) {

                System.out.println("Хотели бы Вы поменять имя? y/n");
                if (scanner.next().equals("y")) {
                    System.out.println("Введите новое имя");
                    name = scanner.nextLine();
                    c.setAttribute("name", name);
                }

                System.out.println("Хотели бы Вы обновить Телефон? y/n");
                if (scanner.next().equals("y")) {
                    System.out.println("Введите новый телефон");
                    if (scanner.hasNextInt()) {
                        int phone = scanner.nextInt();
                        c.getElementsByTagName("phone").item(0).setTextContent("" + phone);
                    }
                }

                System.out.println("Хотели бы Вы обновить Skype? y/n");
                if (scanner.next().equals("y")) {
                    System.out.println("Введите skype");
                    String skype = scanner.nextLine();
                    c.getElementsByTagName("skype").item(0).setTextContent(skype);
                }

                System.out.println("Хотели бы Вы обновить mail? y/n");
                if (scanner.next().equals("y")) {
                    System.out.println("Введите mail");
                    String mail = scanner.nextLine();
                    c.getElementsByTagName("mail").item(0).setTextContent(mail);
                }
            }
        }
        for (int i = 1; i <= nodeList.getLength(); i++) {
            Element c = null;
            try {
                c = (Element) xPath.evaluate("Contacts/Contact[" + i + "]", document, XPathConstants.NODE);
            } catch (XPathExpressionException e) {
                System.out.println("XPath Error");
            }
            if (name.equals(c.getAttribute(name))) {
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
                transform();
                return contact;
            }
        }
        return null;
    }

    @Override
    public Contact delete(Contact contact) {
        nodeList = document.getElementsByTagName("Contact");
        Contact deletedContact;
        Element c = null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            try {
                c = (Element) xPath.evaluate("Contacts/Contact[" + i + "]", document, XPathConstants.NODE);
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }

//            if (contact.getName().equals(c.getAttribute("name"))) {
//                deletedContact = new Contact();
//                try {
//                    deletedContact.setId(Integer.parseInt(xPath.evaluate("Contacts/Contact[" + i + "]/id", document)));
//                    deletedContact.setPhone(Integer.parseInt(xPath.evaluate("Contacts/Contact[" + i + "]/phone", document)));
//
//                    if (!xPath.evaluate("Contacts/Contact[" + i + "]/skype", document).isEmpty()) {
//                        deletedContact.setSkype(xPath.evaluate("Contacts/Contact[" + i + "]/skype", document));
//                    } else deletedContact.setSkype("");
//
//                    if (!xPath.evaluate("Contacts/Contact[" + i + "]/mail", document).isEmpty()) {
//                        deletedContact.setMail(xPath.evaluate("Contacts/Contact[" + i + "]/mail", document));
//                    } else deletedContact.setMail("");
//                } catch (XPathExpressionException e) {
//                    System.out.println("XPath Error");
//                }
                document.getDocumentElement().removeChild(nodeList.item(0));
                transform();
                return contact;
//            }
        }
        return null;
    }

    @Override
    public List<Contact> getAll() {
        List<Contact> contacts = new ArrayList();
        nodeList = document.getElementsByTagName("Contact");
        Element c = null;
        for (int i = 1; i <= nodeList.getLength(); i++) {
            Contact contact = new Contact();
            try {
                c = (Element) xPath.evaluate("Contacts/Contact[" + i + "]", document, XPathConstants.NODE);
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
            try {
                contact.setName(c.getAttribute("name"));
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
            contacts.add(contact);
        }
        return contacts;
    }
}
