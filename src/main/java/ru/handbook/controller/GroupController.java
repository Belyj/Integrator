package ru.handbook.controller;

import ru.handbook.model.objects.Group;
import java.util.List;

public interface GroupController {

    /**
     * <p>Создание новогой группы</p>
     *
     * @param group принемает группу
     * @return Group возвращает группу
     */
    Group createGroup(Group group);

    /**
     * <p>удаление контакта</p>
     *
     * @param group принемает группу
     * @return Group возвращает группу
     */
    Group deleteGroup(Group group);

    /**
     * <p>Обновление контакта</p>
     *
     * @param group принемает группу
     * @return Group возвращает группу
     */
    Group updateGroup(Group group);

    /**
     * <p>Просмотр всех контактов</p>
     *
     * @return Group возвращает список групп
     */
    List<Group> checkGroups();
}
