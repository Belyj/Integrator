package ru.handbook.model.objects;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import ru.handbook.model.utilites.idgenerator.IdGenerator;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "groups")
public class Group implements Serializable {

    @JacksonXmlProperty(isAttribute = true)
    private String name;
    private int id;
    @JacksonXmlElementWrapper(localName = "GroupContacts")
    @JacksonXmlProperty(localName = "GroupContact")
    private List<Contact> groupContacts;

    public Group() {
        id = Integer.parseInt(new IdGenerator().generateGroupId());
        groupContacts = new ArrayList();
    }

    public Group(String name, int id, List<Contact> groupContacts) {
        this.name = name;
        this.id = id;
        this.groupContacts = groupContacts;
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

    public List<Contact> getInner() {
        return groupContacts;
    }

    public void setInner(List<Contact> contacts) {
        groupContacts = contacts;
    }
}
