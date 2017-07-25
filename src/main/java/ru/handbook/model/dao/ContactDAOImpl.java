package ru.handbook.model.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactDAOImpl implements ObjectDAO {

    private String name;
    private List<String> contactGroups;

    public ContactDAOImpl() {
        setName();
        contactGroups = new ArrayList();
    }

    public void setName() {
        Scanner scanner = new Scanner(System.in);
        name = scanner.next();
    }

    public String getName() {
        return name;
    }

    public void setIn(GroupDAOImpl object) {
        contactGroups.add(object.getName());
    }

    public List<String> getOut() {
        return contactGroups;
    }
}
