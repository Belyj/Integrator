package ru.handbook.model.dao;

import sun.net.www.content.text.Generic;

import java.util.List;

public interface ObjectDAO<T> {

    /**
     * <p>Создание новго объекта</p>
     *
     * @param t поиск по объекту
     */
    void create(T t);

    /**
     * <p>Поиск сущности</p>
     *
     * @param t поиск по объекту
     * @return T возвращает объект
     */
    T search(T t);

    /**
     * <p>Обновить поля сущности, используется клонирование при поиске</p>
     *
     * @param t поиск по объекту
     * @param newName новое имя
     */
    void update(T t, String newName);

    /**
     * <p>Удаление сущности</p>
     *
     * @param t поиск по объекту
     */
    void delete(T t);

    /**
     * <p>Просмотр всех сущностей данного типа</p>
     *
     * @return T возвращает список всех сущностей
     */
    List<T> check();
}
