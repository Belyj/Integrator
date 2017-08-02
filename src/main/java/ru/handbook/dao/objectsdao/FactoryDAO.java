package ru.handbook.dao.objectsdao;

public interface FactoryDAO<T> {

    /**
     * <p>Создание новго DAO</p>
     *
     * @return ObjectDAO возвращает созданный экземпляр DAO
     */
    ObjectDAO factoryMethod();
}
