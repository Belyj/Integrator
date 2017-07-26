package ru.handbook.services;

import ru.handbook.model.objects.Group;
import java.util.List;

public interface GroupService {

    /**
     * <p>Получить все группы</p>
     *
     * @return  Group возвращает весь список групп
     */
    List<Group> getAllGroups();

    /**
     * <p>Создать группу</p>
     *
     * @return  Group возвращает группу
     */
    Group createGroup(Group group);

    /**
     * <p>Найти группу</p>
     *
     * @return  Group возвращает группу
     */
    Group getGroup(Group group);

    /**
     * <p>Удалить группу</p>
     *
     * @return  Group возвращает группу
     */
    Group deleteGroup(Group group);

    /**
     * <p>Изменить группу</p>
     *
     * @return  Group возвращает обновленную группу
     */
    Group updateGroup(Group group);
}
