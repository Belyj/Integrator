package ru.handbook.model.objects;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import ru.handbook.model.utilites.IdGenerator;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "contacts")
public class Contact implements Serializable {

    @JacksonXmlProperty(isAttribute = true)
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
