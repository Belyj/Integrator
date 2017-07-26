package ru.handbook.model.objects;

import ru.handbook.model.utilites.IdGenerator;
import java.util.ArrayList;
import java.util.List;

public class Contact {

    private String name;
    private int id;
    private List<String> contactGroups;

    public Contact() {
        id = Integer.parseInt(new IdGenerator().generateContactId());
        contactGroups = new ArrayList();
    }

    public int getId() {
        return id;
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
