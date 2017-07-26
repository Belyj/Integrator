package ru.handbook.controller;

import ru.handbook.model.objects.Contact;

import java.util.List;

public interface ContactController {

    /**
     * <p>Создание нового контакта</p>
     *
     * @param contact принемает контакт
     * @return Contact возвращает контакт
     */
    Contact createContact(Contact contact);

    /**
     * <p>удаление контакта</p>
     *
     * @param contact принемает контакт
     * @return Contact возвращает контакт
     */
    Contact deleteContact(Contact contact);

    /**
     * <p>Обновление контакта</p>
     *
     * @param contact принемает контакт
     * @return Contact возвращает контакт
     */
    Contact updateContact(Contact contact);

    /**
     * <p>Просмотр всех контактов</p>
     *
     * @return Contact возвращает список контактов
     */
    List<Contact> checkContacts();
}
