package ru.handbook.controller;

public interface ContactController {

    /**
     * <p>Создание нового контакта</p>
     */
    void createContact();

    /**
     * <p>удаление контакта</p>
     */
    void deleteContact();

    /**
     * <p>Обновление контакта</p>
     */
    void updateContact();

    /**
     * <p>Просмотр всех контактов</p>
     */
    void checkContacts();
}
