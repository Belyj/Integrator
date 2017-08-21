package ru.handbook.dao.dbdao.mysql.callquery;

import ru.handbook.model.objects.Contact;

import static ru.handbook.Main.userInit;

public class CallContactQuery {

    public String createContact(Contact contact) {
        return "{call createContact(\"" + contact.getName() + "\")}";
    }

    public String getContactByName(Contact contact) {
        return  "{call getContactByName(\"" + contact.getName() + "\", " +
                "\"" + userInit.getUser().getName() + "\"" + ")}";
    }

    public String updateContact(Contact contact, String newName, String newPhone, String newSkype, String newMail) {
        return  "{call updateContact(\"" + contact.getId() + "\", \"" +
                newName + "\", \"" +
                newPhone + "\", \"" +
                newSkype + "\", \"" +
                newMail + "\")}";
    }

    public String deleteContact(Contact contact) {
        return  "{call removeContactByID(\"" + contact.getId() + "\")}";
    }

    public String getAll() {
        return  "{call getContactList(\"" + userInit.getUser().getName() + "\")}";
    }
}
