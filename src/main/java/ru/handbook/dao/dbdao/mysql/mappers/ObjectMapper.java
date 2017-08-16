package ru.handbook.dao.dbdao.mysql.mappers;

import java.sql.ResultSet;
import java.util.List;

public interface ObjectMapper<T> {

    T map(ResultSet resultSet);

    List<T> listMap(ResultSet resultSet);
}
