package ru.handbook;

import ru.handbook.model.utilites.serialization.dom.DOMDeserializer;
import ru.handbook.model.utilites.serialization.jackson.JacksonDeserializer;
import ru.handbook.model.utilites.serialization.jackson.JacksonSerializer;
import ru.handbook.view.ViewStarter;

import static ru.handbook.model.utilites.serialization.standart.StandartSerializer.serialize;

public class Main {

    public static void main(String[] args) {
        //new JacksonDeserializer();
        new DOMDeserializer();
        new ViewStarter();
        //new JacksonSerializer();
        //serialize();
    }
}