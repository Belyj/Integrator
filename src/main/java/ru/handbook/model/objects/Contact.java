package ru.handbook.model.objects;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import ru.handbook.model.utilites.idgenerator.IdGenerator;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "contacts")
public class Contact implements Serializable {

    @JacksonXmlProperty(isAttribute = true)
    private String name;
    private int id;
    private int phone;
    private String skype;
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
