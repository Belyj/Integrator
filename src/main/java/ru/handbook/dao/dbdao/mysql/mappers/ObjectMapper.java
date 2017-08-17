package ru.handbook.dao.dbdao.mysql.mappers;

import java.sql.ResultSet;
import java.util.List;

public interface ObjectMapper<T> {

    /**
     *<p>Читает с резалтсета экземпляр класса</p>
     * @return T возвращает считанный объект класса
     *@param resultSet принемает результат запроса с БД
     */
    T map(ResultSet resultSet);

    /**
     *<p>Читает с резалтсета список экземпляров класса</p>
     * @return T возвращает считанный список объектов класса
     *@param resultSet принемает результат запроса с БД
     */
    List<T> listMap(ResultSet resultSet);
}
