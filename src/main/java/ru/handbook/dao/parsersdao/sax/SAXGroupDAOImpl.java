package ru.handbook.dao.parsersdao.sax;

import org.xml.sax.SAXException;
import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.dao.parsersdao.sax.objecthandlers.GroupHandler;
import ru.handbook.model.objects.Group;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

import static ru.handbook.dao.parsersdao.jackson.test.JacksonDeserializer.createFile;

public class SAXGroupDAOImpl implements ObjectDAO<Group> {

    SAXParserFactory parserFactory = SAXParserFactory.newInstance();
    SAXParser saxParser = createSAXParser();
    GroupHandler groupHander = new GroupHandler();

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
        return null;
    }

    @Override
    public Group update(Group group) {
        return null;
    }

    @Override
    public Group delete(Group group) {
        return null;
    }

    @Override
    public List<Group> getAll() {
        try {
            saxParser.parse(createFile(), groupHander);
            return null;
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
