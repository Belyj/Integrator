package ru.handbook.model.objects;

import java.util.List;

public interface SystemObjects {

    /**
     * <p>Поменять имя</p>
     *
     * @param name с именем
     */
    void setName(String name);
    /**
     * <p>Взять имя</p>
     *
     * @return String имя объекта
     */
    String getName();

    /**
     * <p>Взять список контактов группы</p>
     *
     * @return String список
     */
    List<String> getInner();

    /**
     * <p>Обновить список контактов</p>
     *
     * @param list список
     */
    void setInner(List<String> list);
}
