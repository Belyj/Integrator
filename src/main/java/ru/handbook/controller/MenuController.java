package ru.handbook.controller;

import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.services.ContactServiceImpl;
import ru.handbook.services.GroupServiceImpl;

import java.util.List;

public class MenuController implements ContactController, GroupController {

    ContactServiceImpl contactService = new ContactServiceImpl();
    GroupServiceImpl groupService = new GroupServiceImpl();

    public Contact createContact(Contact contact) {
        return contactService.createContact(contact);
    }

    public Contact searchContact(Contact contact) {
        return contactService.getContact(contact);
    }

    public Group searchGroup(Group group) {
        return groupService.getGroup(group);
    }

    public Group createGroup(Group group) {
        return groupService.createGroup(group);
    }

    public Contact deleteContact(Contact contact) {
        contactService.deleteContact(contact);
        return contact;
    }

    public Group deleteGroup(Group group) {
        groupService.deleteGroup(group);
        return group;
    }

    public Contact updateContact(Contact contact) {
        contactService.updateContact(contact);
        return contact;
    }

    public Group updateGroup(Group group) {
        groupService.updateGroup(group);
        return group;
    }

    public List<Contact> checkContacts() {
        return contactService.getAllContacts();
    }

    public List<Group> checkGroups() {
        return groupService.getAllGroups();
    }
}
