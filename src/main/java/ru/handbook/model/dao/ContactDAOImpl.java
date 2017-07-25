package ru.handbook.model.dao;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.storage.DataStorage;

public class ContactDAOImpl implements ObjectDAO {

    DataStorage source = DataStorage.getInstance();

    public Contact search(String name) {
        for (Contact contact : source.getContacts()) {
            if (contact.getName().equals(name)) {
                System.out.println(contact.getName());
                return contact;
            }
        }
        System.out.println("Контакта не существует");
        return null;
    }

    public void update(String name, String newName) {
        search(name).setName(newName);
    }

    public void delete(String name) throws CloneNotSupportedException {
        Contact deletedContact = search(name);
        source.getGroups().remove(deletedContact);
    }

    public void check() {
        for (Contact contact : source.getContacts()) {
            System.out.println(contact.getName());
        }
    }
}
