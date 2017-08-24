package ru.handbook.dao.objectsdao.daoimpl.productdao;

import ru.handbook.dao.objectsdao.ObjectDAO;
import ru.handbook.model.objects.Group;
import ru.handbook.model.storage.DataStorage;

import java.util.List;
import java.util.Scanner;

public class GroupDAOImpl implements ObjectDAO<Group> {

    DataStorage source = DataStorage.getInstance();
    List<Group> groupsBase = source.getGroups();

    public Group getByName(Group group) {
        return source.getGroupByName(group.getName());
    }

    @Override
    public Group getByID(Group group) {
        return null;
    }

    public Group update(Group group) {
        int id = source.getGroupByName(group.getName()).getId();
        source.getGroups().remove(source.getGroupByName(group.getName()));
        System.out.println("Введите новое имя");
        group.setName(new Scanner(System.in).nextLine());
        group.setId(id);
        source.getGroups().add(group);
        return source.getGroupByName(group.getName());
    }

    public Group delete(Group group) {
        Group deletedGroup = getByName(group);
        groupsBase.remove(deletedGroup);
        return deletedGroup;
    }

    public List<Group> getAll() {
        return groupsBase;
    }

    public Group create(Group group) {
        return source.setGroup(group);
    }
}
