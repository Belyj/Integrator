package ru.handbook.dao.parsersdao.jackson;

import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.model.objects.Group;
import ru.handbook.model.utilites.validator.XMLValidator;

import java.util.List;

public class JacksonGroupDAOImpl implements ObjectDAO<Group> {

    public JacksonGroupDAOImpl() {
        if (new XMLValidator().validateXMLSchema("src/main/java/ru/handbook/model/utilites/validator/xsd/GroupSchema.xsd", "group.xml")) {
            System.out.println("Validate is ok");
        } else System.out.println("Validate error");
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
        return null;
    }
}
