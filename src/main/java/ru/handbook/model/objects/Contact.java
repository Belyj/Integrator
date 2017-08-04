package ru.handbook.model.objects;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import ru.handbook.model.utilites.idgenerator.IdGenerator;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

public class Contact implements Serializable {

    @JacksonXmlProperty(isAttribute = true)
    private String name;
    @JacksonXmlProperty(localName = "id")
    private int id;
    @JacksonXmlProperty(localName = "phone")
    private int phone;
    @JacksonXmlProperty(localName = "skype")
    private String skype;
    @JacksonXmlProperty(localName = "mail")
    private String mail;

    public void setPhone(int telephone) {
        this.phone = telephone;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getPhone() {

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

    public Contact(String name, int id, int phone, String skype, String mail) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.skype = skype;
        this.mail = mail;
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
