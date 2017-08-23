package ru.handbook.dao.objectsdao;

public interface UserFactoryDAO {

    /**
     * <p>Создание новго DAO</p>
     *
     * @return Group возвращает созданный экземпляр DAO
     */
    UserDAO factoryMethod();
}
