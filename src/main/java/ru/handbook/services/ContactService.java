package ru.handbook.services;

import ru.handbook.model.objects.Contact;

import java.util.List;

public interface ContactService {

    /**
     * <p>Получить все контакты</p>
     *
     * @return  Contact возвращает весь список контактов
     */
    List<Contact> getAllContacts();

    /**
     * <p>Создать контакт</p>
     *
     * @return  Contact возвращает контакт
     */
    Contact createContact(Contact contact);

    /**
     * <p>Найти контакт</p>
     *
     * @return  Contact возвращает контакт
     */
    Contact getContact(Contact contact);

    /**
     * <p>Удалить контакт</p>
     *
     * @return  Contact возвращает контакт
     */
    Contact deleteContact(Contact contact);

    /**
     * <p>Изменить контакт</p>
     *
     * @return  Contact возвращает обновленный контакт
     */
    Contact updateContact(Contact contact);
}
