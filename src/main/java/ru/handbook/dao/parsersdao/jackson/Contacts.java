package ru.handbook.dao.parsersdao.jackson;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.storage.DataStorage;

@JacksonXmlRootElement(localName = "Contacts")
public class Contacts {

    @JacksonXmlProperty(localName = "Contact")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Contact[] contacts;
    DataStorage dataStorage = DataStorage.getInstance();

    public Contacts(Contact[] contacts) {
        this.contacts = contacts;
    }

    public Contacts() {
    }

    public Contact[] getContacts() {
        return contacts;
    }

    public void setContacts(Contact[] contacts) {
        for (int i = 0; i < contacts.length; i++) {
            dataStorage.getContacts().add(contacts[i]);
        }
    }
}
