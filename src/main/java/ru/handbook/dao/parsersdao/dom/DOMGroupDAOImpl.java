package ru.handbook.dao.parsersdao.dom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.model.objects.Group;

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

public class DOMGroupDAOImpl implements ObjectDAO<Group> {

    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    Document document = createDocument();
    Scanner scanner = new Scanner(System.in);
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    DOMSource domSource = new DOMSource(document);
    StreamResult streamResult = new StreamResult(new File("group.xml"));
    Transformer transformer = createTransformer(transformerFactory);

    XPathFactory xPathFactory = XPathFactory.newInstance();
    XPath xPath = xPathFactory.newXPath();
    NodeList nodeList;

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
    public Group create(Group group) {
        Node rootElement = document.getDocumentElement();

        if (rootElement == null) {
            rootElement = document.createElement("Groups");
            document.appendChild(rootElement);
        }

        Element groupEl = document.createElement("Group");
        Attr groupAttribute = document.createAttribute("name");
        groupAttribute.setValue(group.getName());

        Element groupIdEl = document.createElement("id");
        groupEl.appendChild(groupIdEl).setTextContent(String.valueOf(group.getId()));
        groupEl.setAttributeNode(groupAttribute);
        rootElement.appendChild(groupEl);
        transform();

        nodeList = document.getElementsByTagName("Group");
        Group createdGroup = new Group();
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

    private Document createDoc() {
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            document = createDocBuilder().parse("group.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    @Override
    public Group getByName(Group group) {
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
                    name = scanner.nextLine();
                    g.setAttribute("name", name);
                }
            }
        }
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

    @Override
    public Group delete(Group group) {
        nodeList = document.getElementsByTagName("Group");
        Group deletedGroup;
        Element g = null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            try {
                g = (Element) xPath.evaluate("Groups/Group[" + i + "]", document, XPathConstants.NODE);
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }

//            if (group.getName().equals(g.getAttribute("name"))) {
//                deletedGroup = new Group();
//                try {
//                    deletedGroup.setId(Integer.parseInt(xPath.evaluate("Groups/Group[" + i + "]/id", document)));
//                } catch (XPathExpressionException e) {
//                    System.out.println("XPath Error");
//                }
                document.getDocumentElement().removeChild(nodeList.item(0));
                transform();
                return group;
//            }
        }
        return null;
    }

    @Override
    public List<Group> getAll() {
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
            } catch (XPathExpressionException e) {
                System.out.println("XPath Error");
            }
            groups.add(group);
        }
        return groups;
    }
}
