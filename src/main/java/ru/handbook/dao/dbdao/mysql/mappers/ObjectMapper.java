package ru.handbook.dao.dbdao.mysql.mappers;

import java.sql.ResultSet;
import java.util.List;

public interface ObjectMapper<T> {

    /**
     * <p>Читает с резалтсета экземпляр класса</p>
     *
     * @param resultSet принемает результат запроса с БД
     * @return T возвращает считанный объект класса
     */
    T map(ResultSet resultSet);

    /**
     * <p>Читает с резалтсета список экземпляров класса</p>
     *
     * @param resultSet принемает результат запроса с БД
     * @return T возвращает считанный список объектов класса
     */
    List<T> listMap(ResultSet resultSet);
}
