package ru.handbook.controller;

import org.apache.log4j.Logger;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;
import ru.handbook.services.servicesimpl.ContactServiceImpl;
import ru.handbook.services.servicesimpl.GroupServiceImpl;

import java.util.List;

public class MenuController implements ContactController, GroupController {

    ContactServiceImpl contactService = new ContactServiceImpl();
    GroupServiceImpl groupService = new GroupServiceImpl();

    private static final Logger log = Logger.getLogger(MenuController.class);

    public Contact createContact(Contact contact) {
        log.info("Запущено создание кантакта");
        return contactService.createContact(contact);
    }

    public List<Contact> searchContact(Contact contact) {
        log.info("Запущен поиск контакта по имени");
        return contactService.getContactByName(contact);
    }

    public Contact searchContactByID(Contact contact) {
        log.info("Запущен поиск контакта по ID");
        return contactService.getContactByID(contact);
    }

    public List<Group> searchGroup(Group group) {
        log.info("Запущен поиск группы по имени");
        return groupService.getGroupByName(group);
    }

    public Group searchGroupByID(Group group) {
        log.info("Запущен поиск группы по ID");
        return groupService.getGroupByID(group);
    }

    public Group createGroup(Group group) {
        log.info("Запущено создание группы");
        return groupService.createGroup(group);
    }

    public Contact deleteContact(Contact contact) {
        log.info("Запущено удаление контакта");
        return contactService.deleteContact(contact);
    }

    public Group deleteGroup(Group group) {
        log.info("Запущено удаление группы");
        return groupService.deleteGroup(group);
    }

    public Contact updateContact(Contact contact) {
        log.info("Запущено обновление контакта");
        contactService.updateContact(contact);
        return contact;
    }

    public Group updateGroup(Group group) {
        log.info("Запущено обновление группы");
        return groupService.updateGroup(group);
    }

    public void addInGroup(Contact contact, Group group) {
        log.info("Запущено добавление в группу");
        groupService.addInGroup(contact, group);
    }

    public void removeFromGroup(Contact contact, Group group) {
        log.info("Запущено удаление из группы");
        groupService.removeFromGroup(contact, group);
    }

    public List<Contact> checkContacts() {
        log.info("Запущен поиск всех контактов");
        return contactService.getAllContacts();
    }

    public List<Group> checkGroups() {
        log.info("Запущен поиск всех групп");
        return groupService.getAllGroups();
    }
}
