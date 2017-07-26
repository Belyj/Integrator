package ru.handbook.dao;

public interface FactoryDAO<T> {

    /**
     * <p>Создание новго DAO</p>
     *
     * @return ObjectDAO возвращает созданный экземпляр DAO
     */
    ObjectDAO factoryMethod();
}
