package ru.handbook.dao.parsersdao.sax;

import org.xml.sax.SAXException;
import ru.handbook.dao.objectsdao.GroupDAO;
import ru.handbook.dao.parsersdao.sax.objecthandlers.GroupHandler;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.model.utilites.validator.XMLValidator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.List;


public class SAXGroupDAOImpl implements GroupDAO {

    SAXParserFactory parserFactory = SAXParserFactory.newInstance();
    SAXParser saxParser = createSAXParser();
    GroupHandler groupHander = new GroupHandler();

    public SAXGroupDAOImpl() {
        if (new XMLValidator().validateXMLSchema("src/main/java/ru/handbook/model/utilites/validator/xsd/GroupSchema.xsd", "group.xml")) {
            System.out.println("Validate is ok");
        } else System.out.println("Validate error");
    }

    private SAXParser createSAXParser() {
        try {
            return parserFactory.newSAXParser();
        } catch (ParserConfigurationException e) {
            System.out.println("Pareser configuration error");
        } catch (SAXException e) {
            e.toString();
        }
        return null;
    }

    @Override
    public Group create(Group group) {
        return null;
    }

    @Override
    public Group getByName(Group group) {
        List<Group> groups;
        if (!new File("group.xml").exists()) {
            String path = new File("").getAbsolutePath();
            new File(path, "group.xml");
        }
        try {
            InputStream inputStream = new FileInputStream("group.xml");
            try {
                saxParser.parse(inputStream, groupHander);
                groups = groupHander.getGroups();
                for (Group g : groups) {
                    if (g.getName().equals(group.getName())) {
                        return g;
                    }
                }
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Group getByID(Group group) {
        return null;
    }

    @Override
    public Group update(Group group) {
        System.out.println("Только для чтения");
        return null;
    }

    @Override
    public Group delete(Group group) {
        System.out.println("Только для чтения");
        return null;
    }

    @Override
    public List<Group> getAll() {
        return groupHander.getGroups();
    }

    public void removeFromGroup(Contact contact, Group group) {
        System.out.println("Только для чтения");
    }

    public void addInGroup(Contact contact, Group group) {
        System.out.println("Только для чтения");
    }
}
