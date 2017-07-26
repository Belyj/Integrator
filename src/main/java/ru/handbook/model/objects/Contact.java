package ru.handbook.model.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contact {

    private String name;
    private int id;
    private List<String> contactGroups;

    public Contact() {
        contactGroups = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getInner() {
        return contactGroups;
    }

    public void setInner(List<String> groups) {
        contactGroups = groups;
    }
}
