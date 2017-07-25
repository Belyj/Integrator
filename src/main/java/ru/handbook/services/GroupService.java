package ru.handbook.services;

import ru.handbook.model.objects.Group;

import java.util.List;

public interface GroupService {

    List<Group> getAllGroups();

    Group createGroup(Group group);

    Group searchGroup(Group group);

    Group deleteGroup(Group group);

    Group updateGroup(Group group);
}
