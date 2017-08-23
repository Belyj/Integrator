package ru.handbook.model.objects;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import ru.handbook.model.storage.Observable;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "groups")
public class Group implements Serializable, Observable {

    List<ru.handbook.view.contactview.Observer> observers = new ArrayList();
    @JacksonXmlProperty(isAttribute = true)
    private String name;
    private int id;
    @JacksonXmlElementWrapper(localName = "GroupContacts")
    @JacksonXmlProperty(localName = "GroupContact")
    private List<Contact> groupContacts;


    public Group() {
        id = 0;
        groupContacts = new ArrayList();
    }

    public Group(String name) {
        id = 0;
        groupContacts = new ArrayList();
        this.name = name;
    }

    public Group(int id, String name, List<Contact> groupContacts) {
        this.id = id;
        this.name = name;
        this.groupContacts = groupContacts;
    }

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Contact> getInner() {
        return groupContacts;
    }

    public void setInner(List<Contact> contacts) {
        groupContacts = contacts;
    }

    @Override
    public void addObserver(ru.handbook.view.contactview.Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ru.handbook.view.contactview.Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ru.handbook.view.contactview.Observer o : observers) {
            o.handleEvent();
        }
    }

    public List<ru.handbook.view.contactview.Observer> getObservers() {
        return observers;
    }
}
