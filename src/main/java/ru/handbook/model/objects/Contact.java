package ru.handbook.model.objects;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import ru.handbook.model.storage.Observable;
import ru.handbook.view.contactview.Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "Contact")
public class Contact implements Serializable, Observable {

    @JacksonXmlProperty(localName = "name", isAttribute = true)
    private String name;
    @JacksonXmlProperty(localName = "id")
    private int id;
    @JacksonXmlProperty(localName = "phone")
    private String phone;
    @JacksonXmlProperty(localName = "skype")
    private String skype;
    @JacksonXmlProperty(localName = "mail")
    private String mail;
    List<Observer> observers = new ArrayList();

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {

        return phone;
    }

    public String getSkype() {
        return skype;
    }

    public String getMail() {
        return mail;
    }

    public Contact() {
        id = 0;
        skype = "";
        mail = "";
    }
    public Contact(int id) {
        this.id = id;
    }

    public Contact(String name) {
        this.name = name;
    }

    public Contact( int id, String name, String phone, String skype, String mail) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.skype = skype;
        this.mail = mail;
    }

    public Contact(int id, String name) {
        this.name = name;
        this.id = id;
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

    @Override
    public String toString() {
        return  "id: " + id + "\t" +
                "name: " + name + "\t" +
                "phone: " + phone + "\t" +
                "skype: " + skype + "\t" +
                "mail: " + mail;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.handleEvent();
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
