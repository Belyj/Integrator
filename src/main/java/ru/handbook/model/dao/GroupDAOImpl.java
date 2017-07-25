package ru.handbook.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroupDAOImpl implements ObjectDAO {

    private String name;
    private List<String> groupContacts;

    public GroupDAOImpl() {
        setName();
        groupContacts = new ArrayList();
    }

    public void setName() {
        Scanner scanner = new Scanner(System.in);
        name = scanner.next();
    }

    public String getName() {
        return name;
    }

    public void setIn(ContactDAOImpl object) {
        groupContacts.add(object.getName());
    }

    public List<String> getOut() {
        return groupContacts;
    }
}
