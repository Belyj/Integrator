package ru.handbook.controller;

import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.services.servicesimpl.ContactServiceImpl;
import ru.handbook.services.servicesimpl.GroupServiceImpl;

import java.util.List;

public class MenuController implements ContactController, GroupController {

    ContactServiceImpl contactService = new ContactServiceImpl();
    GroupServiceImpl groupService = new GroupServiceImpl();

    public Contact createContact(Contact contact) {
        return contactService.createContact(contact);
    }

    public List<Contact> searchContact(Contact contact) {
        return contactService.getContactByName(contact);
    }

    public Contact searchContactByID(Contact contact) {
        return contactService.getContactByID(contact);
    }

    public List<Group> searchGroup(Group group) {
        return groupService.getGroupByName(group);
    }

    public Group searchGroupByID(Group group) {
        return groupService.getGroupByID(group);
    }

    public Group createGroup(Group group) {
        return groupService.createGroup(group);
    }

    public Contact deleteContact(Contact contact) {
        return contactService.deleteContact(contact);
    }

    public Group deleteGroup(Group group) {

        return groupService.deleteGroup(group);
    }

    public Contact updateContact(Contact contact) {
        contactService.updateContact(contact);
        return contact;
    }

    public Group updateGroup(Group group) {
        return groupService.updateGroup(group);
    }

    public void addInGroup(Contact contact, Group group) {
        groupService.addInGroup(contact, group);
    }

    public void removeFromGroup(Contact contact, Group group) {
        groupService.removeFromGroup(contact, group);
    }

    public List<Contact> checkContacts() {
        return contactService.getAllContacts();
    }

    public List<Group> checkGroups() {
        return groupService.getAllGroups();
    }
}
