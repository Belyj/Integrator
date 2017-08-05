package ru.handbook.dao.objectsdao;

public interface GroupFactoryDAO {
    /**
     * <p>Создание новго DAO</p>
     *
     * @return Group возвращает созданный экземпляр DAO
     */
    GroupDAO factoryMethod();
}
