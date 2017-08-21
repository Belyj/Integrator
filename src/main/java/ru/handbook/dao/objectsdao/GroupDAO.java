package ru.handbook.dao.objectsdao;

import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;

public interface GroupDAO extends ObjectDAO<Group> {

    /**
     * <p>удаление контакта из группы</p>
     *
     * @param contact поиск контакта
     * @param group поиск группы
     */
    public void deleteFromGroup(Contact contact, Group group);

    /**
     * <p>добавление контакта в группу</p>
     *
     * @param contact поиск контакта
     * @param group поиск группы
     */
    public void addInGroup(Contact contact, Group group);
}
