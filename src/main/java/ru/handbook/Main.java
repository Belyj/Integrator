package ru.handbook;

import org.xml.sax.SAXException;
import ru.handbook.model.utilites.serialization.dom.DOMDeserializer;
import ru.handbook.model.utilites.serialization.dom.DOMSerializer;
import ru.handbook.model.utilites.serialization.jackson.JacksonDeserializer;
import ru.handbook.model.utilites.serialization.jackson.JacksonSerializer;
import ru.handbook.view.ViewStarter;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static ru.handbook.model.utilites.serialization.standart.StandartSerializer.serialize;

public class Main {

    public static void main(String[] args) {
        //new JacksonDeserializer();
        new DOMDeserializer();
        new ViewStarter();
        new DOMSerializer();
        //new JacksonSerializer();
        //serialize();
    }
}