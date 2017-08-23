package ru.handbook.dao.objectsdao;

import ru.handbook.model.objects.User;

public interface UserDAO {

    /**
     * <p>Поиск User</p>
     *
     * @param login поиск по имени
     * @param password и паролю
     * @return User возвращает пользователя
     */
    User getByParams(String login, String password);
}
