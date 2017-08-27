package ru.handbook.dao.objectsdao;

import ru.handbook.model.objects.Contact;

import java.util.List;

public interface ObjectDAO<T> {

    /**
     * <p>Создание новго объекта</p>
     *
     * @param t поиск по объекту
     * @return T возвращает созданный объект
     */
    T create(T t);

    /**
     * <p>Поиск сущности</p>
     *
     * @param t поиск по объекту
     * @return T возвращает объект
     */
    List<Contact> getByName(T t);

    /**
     * <p>Поиск сущности</p>
     *
     * @param t поиск по объекту
     * @return T возвращает объект
     */
    T getByID(T t);

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
     * @return T возвращает удаленный объект
     */
    T delete(T t);

    /**
     * <p>Просмотр всех сущностей данного типа</p>
     *
     * @return T возвращает список всех сущностей
     */
    List<T> getAll();
}
