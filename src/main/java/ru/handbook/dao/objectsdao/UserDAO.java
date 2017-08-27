package ru.handbook.dao.objectsdao;

import ru.handbook.model.objects.User;

import java.util.List;

public interface UserDAO {

    /**
     * <p>Поиск User</p>
     *
     * @param login    поиск по имени
     * @param password и паролю
     * @return User возвращает пользователя
     */
    User getByParams(String login, String password);

    /**
     * <p>Подсчет среднего количества пользователей в группе</p>
     *
     * @return Int возвращает число
     */
    public Float avgContactsInGroups();

    /**
     * <p>Подсчет среднего количества контактов у пользователей</p>
     *
     * @return Int возвращает число
     */
    public Float avgCountOfContacts();

    /**
     * <p>Поиск неактивных пользователей</p>
     *
     * @return List<User> возвращает список неактивных пользователей и количество их контактов</User>
     */
    public List<User> unactiveList();

    /**
     * <p>Вывод числа контактов у пользователей</p>
     *
     * @return List<User> возвращает список пользователей и количество их контактов</User>
     */
    public List<User> userContactsCount();

    /**
     * <p>Подсчет количества пользователей</p>
     *
     * @return Int возвращает число
     */
    public Float userCount();

    /**
     * <p>Вывод числа групп у пользователей</p>
     *
     * @return List<User> возвращает список пользователей и количество их групп</User>
     */
    public List<User> userGroupsCount();
}
