package ru.handbook.dao.parsersdao.dom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import ru.handbook.dao.objectsdao.GroupDAO;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.model.utilites.idgenerator.IdGenerator;
import ru.handbook.model.utilites.validator.XMLValidator;

import javax.print.Doc;
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
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DOMGroupDAOImpl implements GroupDAO {

    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = createDocumentBuilder();
    Document document = null;
    InputStream inputStream = createInputStream();
    Scanner scanner = new Scanner(System.in);
    XPathFactory xPathFactory = XPathFactory.newInstance();
    XPath xPath = xPathFactory.newXPath();
    NodeList nodeList;

    public DOMGroupDAOImpl() {
        if (new XMLValidator().validateXMLSchema("src/main/java/ru/handbook/model/utilites/validator/xsd/GroupSchema.xsd", "group.xml")) {
            System.out.println("Validate is ok");
        } else System.out.println("Validate error");
    }

    private FileInputStream createInputStream() {
        if (!new File("group.xml").exists()) {
            String path = new File("").getAbsolutePath();
            new File(path, "group.xml");
        }
        try {
            return new FileInputStream("group.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private DocumentBuilder createDocumentBuilder() {
        try {
            return documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void transform() {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        try {
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("group.xml"));
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private Document readingStream() {
        try {
            return documentBuilder.parse(inputStream);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Group create(Group group) {
        document = readingStream();
        Node rootElement = document.getDocumentElement();
        Group createdGroup = new Group();

        if (rootElement == null) {
            rootElement = document.createElement("Groups");
            document.appendChild(rootElement);
        }
        group.setId(Integer.parseInt(new IdGenerator().generateGroupId(getAll())));

        Element groupEl = document.createElement("Group");
        Attr groupAttribute = document.createAttribute("name");
        groupAttribute.setValue(group.getName());

        Element groupContacts = document.createElement("GroupContacts");
        groupEl.appendChild(groupContacts);

        Element groupIdEl = document.createElement("id");
        groupEl.appendChild(groupIdEl).setTextContent(String.valueOf(group.getId()));
        groupEl.setAttributeNode(groupAttribute);
        rootElement.appendChild(groupEl);
        transform();

        nodeList = document.getElementsByTagName("Group");
        createdGroup.setName(group.getName());
        for (int i = 1; i <= nodeList.getLength(); i++) {
            Element g = null;
            try {
                g = (Element) xPath.evaluate("Groups/Group[" + i + "]", document, XPathConstants.NODE);
            } catch (XPathExpressionException e) {
                System.out.println("XPath Error");
            }
            if (group.getName().equals(g.getAttribute("name"))) {
                try {
                    createdGroup.setId(Integer.parseInt(xPath.evaluate("Groups/Group[" + i + "]/id", document)));
                } catch (XPathExpressionException e) {
                    System.out.println("XPath Error");
                }
            }
        }
        return createdGroup;
    }

    @Override
    public Group getByName(Group group) {
        document = readingStream();
        nodeList = document.getElementsByTagName("Group");
        for (int i = 1; i <= nodeList.getLength(); i++) {
            Element g = null;
            try {
                g = (Element) xPath.evaluate("Groups/Group[" + i + "]", document, XPathConstants.NODE);
            } catch (XPathExpressionException e) {
                System.out.println("XPath Error");
            }
            if (group.getName().equals(g.getAttribute("name"))) {
                try {
                    group.setId(Integer.parseInt(xPath.evaluate("Groups/Group[" + i + "]/id", document)));
                } catch (XPathExpressionException e) {
                    System.out.println("XPath Error");
                }
                return group;
            }
        }
        return null;
    }

    @Override
    public Group update(Group group) {
        document = readingStream();
        String name = group.getName();
        nodeList = document.getElementsByTagName("Group");

        for (int i = 1; i <= nodeList.getLength(); i++) {
            Element g = null;
            try {
                g = (Element) xPath.evaluate("Groups/Group[" + i + "]", document, XPathConstants.NODE);
            } catch (XPathExpressionException e) {
                System.out.println("XPath Error");
            }

            if (name.equals(g.getAttribute("name"))) {

                System.out.println("Хотели бы Вы поменять имя? y/n");
                if (scanner.next().equals("y")) {
                    System.out.println("Введите новое имя");
                    name = scanner.next();
                    g.setAttribute("name", name);
                }
            }
            transform();
        }
        document = readingStream();
        for (int i = 1; i <= nodeList.getLength(); i++) {
            Element c = null;
            try {
                c = (Element) xPath.evaluate("Groups/Group[" + i + "]", document, XPathConstants.NODE);
            } catch (XPathExpressionException e) {
                System.out.println("XPath Error");
            }
            if (name.equals(c.getAttribute(name))) {
                try {
                    group.setId(Integer.parseInt(xPath.evaluate("Groups/Group[" + i + "]/id", document)));
                } catch (XPathExpressionException e) {
                    System.out.println("XPath Error");
                }
                transform();
                return group;
            }
        }
        return null;
    }

    public void addInGroup(Contact contact, Group group) {
        document = readingStream();
        Integer contactId = contact.getId();
        nodeList = document.getElementsByTagName("Group");

        for (int i = 1; i <= nodeList.getLength(); i++) {
            Element g = null;
            Element gc = null;

            try {
                g = (Element) xPath.evaluate("Groups/Group[" + i + "]", document, XPathConstants.NODE);
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
            if (group.getName().equals(g.getAttribute("name"))) {
                group.getInner().add(contactId);
                try {
                    gc = (Element) xPath.evaluate("Groups/Group[" + i + "]/GroupContacts", document, XPathConstants.NODE);
                } catch (XPathExpressionException e) {
                    e.printStackTrace();
                }
                Element contactNode = document.createElement("ContactID");
                contactNode.setTextContent(String.valueOf(contactId));
                gc.appendChild(contactNode);
            }
        }
        transform();
    }

    public void deleteFromGroup(Contact contact, Group group) {
        Element g = null;
        Element gc = null;
        Integer id = null;
        Contact deleted;
        DOMContactDAOImpl domContactDAO = new DOMContactDAOImpl();
        deleted = domContactDAO.getByName(contact);
        id = deleted.getId();

        document = readingStream();
        nodeList = document.getElementsByTagName("Group");
        for (int i = 1; i <= nodeList.getLength(); i++) {
            try {
                g = (Element) xPath.evaluate("Groups/Group[" + i + "]", document, XPathConstants.NODE);
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
            NodeList contactsID = document.getElementsByTagName("ContactID");

            if (group.getName().equals(g.getAttribute("name"))) {
                for (int j = 1; j <= contactsID.getLength(); j++) {
                    try {
                        gc = (Element) xPath.evaluate("Groups/Group[" + i + "]/GroupContacts/ContactID[" + j + "]", document, XPathConstants.NODE);
                    } catch (XPathExpressionException e) {
                        e.printStackTrace();
                    }
                }
                if (id.equals(gc.getTextContent())) {
                    document.getDocumentElement().removeChild(nodeList.item(i - 1));
                    transform();
                }
            }
        }
    }


    @Override
    public Group delete(Group group) {
        document = readingStream();
        nodeList = document.getElementsByTagName("Group");
        Group deletedGroup;
        Element g = null;
        for (int i = 1; i <= nodeList.getLength(); i++) {
            try {
                g = (Element) xPath.evaluate("Groups/Group[" + i + "]", document, XPathConstants.NODE);
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }

            if (group.getName().equals(g.getAttribute("name"))) {
                deletedGroup = new Group();
                try {
                    deletedGroup.setId(Integer.parseInt(xPath.evaluate("Groups/Group[" + i + "]/id", document)));
                } catch (XPathExpressionException e) {
                    System.out.println("XPath Error");
                }
                document.getDocumentElement().removeChild(nodeList.item(i - 1));
                transform();
                return deletedGroup;
            }
        }
        return null;
    }

    @Override
    public List<Group> getAll() {
        document = readingStream();

        List<Group> groups = new ArrayList();
        nodeList = document.getElementsByTagName("Group");
        Element g = null;

        for (int i = 1; i <= nodeList.getLength(); i++) {
            Group group = new Group();
            try {
                g = (Element) xPath.evaluate("Groups/Group[" + i + "]", document, XPathConstants.NODE);
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
            try {
                group.setName(g.getAttribute("name"));
                group.setId(Integer.parseInt(xPath.evaluate("Groups/Group[" + i + "]/id", document)));

                NodeList contactsID = document.getElementsByTagName("ContactID");
                Element gc = null;

                for (int j = 1; j <= contactsID.getLength(); j++) {
                    gc = (Element) xPath.evaluate("Groups/Group[" + i + "]/GroupContacts/ContactID[" + j +"]", document, XPathConstants.NODE);
                    if (gc != null) {
                        group.getInner().add(Integer.parseInt(gc.getTextContent()));
                    }
                }
            } catch (XPathExpressionException e) {
                System.out.println("XPath Error");
            }
            groups.add(group);
        }
        return groups;
    }
}
