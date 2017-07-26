package ru.handbook.dao;

import ru.handbook.model.objects.Contact;
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

    public Group update(Group group) {
        Group g = getByName(group);
        System.out.println("Введите новое имя");
        g.setName(new Scanner(System.in).nextLine());
        return g;
    }

    public void delete(Group g) {
        Group deletedGroup = getByName(g);
        groupsBase.remove(deletedGroup);
    }

    public List<Group> getAll() {
        for (Group group : groupsBase) {
            System.out.println(group.getName());
        }
        return source.getGroups();
    }

    public void create(Group group) {
        source.setGroup(group);
    }
}
