package ru.handbook;

import ru.handbook.model.utilites.datechooser.DataChooser;
import ru.handbook.view.UserInit;
import ru.handbook.view.ViewStarter;

public class Main {

    public static UserInit userInit;
    public static void main(String[] args) {
        userInit = new UserInit();
        new ViewStarter();
    }
}