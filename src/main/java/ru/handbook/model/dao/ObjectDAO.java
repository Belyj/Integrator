package ru.handbook.model.dao;

import java.util.List;

public interface ObjectDAO {

    /**
     * <p>Поиск сущности</p>
     *
     * @param name поиск по имени
     *
     * @return T возвращает объект
     */
    Object search(String name);

    /**
     * <p>Обновить поля сущности, используется клонирование при поиске</p>
     *
     * @param name поиск по имени
     */
    void update(String name, String newName);

    /**
     * <p>Удаление сущности, используется клонирование при поиске</p>
     *
     * @param name поиск по имени
     */
    void delete(String name) throws CloneNotSupportedException;

    /**
     * <p>Просмотр всех сущностей данного типа</p>
     */
    void check();
}
