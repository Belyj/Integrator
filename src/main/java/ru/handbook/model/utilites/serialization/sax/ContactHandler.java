package ru.handbook.model.utilites.serialization.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

public class ContactHandler extends DefaultHandler {

    private String name;
    private String element;
    private Map<String, Integer> data = new HashMap();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        element = qName;
        if (element.equals("Contact")) {
            name = attributes.getValue(0);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        element = "";
        name = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (element.equals("id")) {
            if (name != null && !name.isEmpty()) {
                int id = Integer.parseInt(new String(ch, start, length));
                data.put(name, id);
            }
        }
    }

    public Map<String, Integer> getData() {
        return data;
    }
}
