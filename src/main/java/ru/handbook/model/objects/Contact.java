package ru.handbook.model.objects;

import ru.handbook.model.utilites.IdGenerator;
import java.util.ArrayList;
import java.util.List;

public class Contact {

    private String name;
    private int id;

    public Contact() {
        id = Integer.parseInt(new IdGenerator().generateContactId());
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
}
