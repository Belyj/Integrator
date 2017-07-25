package ru.handbook.model.dao;

import java.util.List;

public interface ObjectDAO {

    void setName();

    String getName();

    //void setIn(ObjectDAO object);

    List<String> getOut();
}
