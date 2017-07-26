package ru.handbook.dao;

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
    T getByName(T t);

    /**
     * <p>Обновить поля сущности, используется клонирование при поиске</p>
     *
     * @param t поиск по объекту
     * @return T возвращает объект
     */
    T update(T t);

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
    List<T> getAll();
}