package ru.handbook.view.contactview;

import java.util.List;

public interface Observer {

    void handleEvent(List<String> contacts);
}
