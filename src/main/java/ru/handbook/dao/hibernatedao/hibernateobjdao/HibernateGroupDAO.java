package ru.handbook.dao.hibernatedao.hibernateobjdao;

import ru.handbook.model.objects.Group;

import java.util.List;

public interface HibernateGroupDAO {

    List<Group> getByName(Group group);
    Group getByID(Group group);
    List<Group> getAll();
    Group create(Group group);
    Group update(Group group);
    Group delete(Group group);
}
