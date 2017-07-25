package ru.handbook.model.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contact implements SystemObjects {

    private String name;
    private List<String> contactGroups;
    Scanner scanner = new Scanner(System.in);

    void Contact() {
        System.out.println("Введите имя");
        setName(scanner.next());
        contactGroups = new ArrayList();
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
