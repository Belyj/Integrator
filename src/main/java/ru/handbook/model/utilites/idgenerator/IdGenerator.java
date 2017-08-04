package ru.handbook.model.utilites.idgenerator;

import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.model.storage.DataStorage;
import ru.handbook.services.servicesimpl.ContactServiceImpl;

import java.util.List;

/**
 * Created by operator1 on 26.07.2017.
 */
public class IdGenerator {

    DataStorage source = DataStorage.getInstance();
    //List<Contact> contacts = new ContactServiceImpl().getAllContacts();

    public String generateContactId(List<Contact> contacts) {
        int max = 1;
        for (Contact contact : contacts) {
            if (contact != null) {
                if (max <= contact.getId() % 10) {
                    max = contact.getId() % 10 + 1;
                }
            }
        }
        return "1" + max;
    }

    public String generateGroupId() {
        int max = 1;
        for (Group group : source.getGroups()) {
            if (group != null) {
                if (max <= group.getId() % 10) {
                    max = group.getId() % 10 + 1;
                }
            }
        }
        return "2" + max;
    }
}
