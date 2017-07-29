package ru.handbook.model.utilites.serialization.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

public class Handler extends DefaultHandler {

    private int id;
    private String name;
    private String element;
    private Map<String, Integer> data = new HashMap();

    @Override

    public void startDocument() throws SAXException {
        System.out.println("start parsing...");

    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("end parsing...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        element = qName;
        if (element.equals("Contact") || element.equals("Group") || element.equals("GroupContact")) {
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
            int id = Integer.parseInt(new String(ch, start, length));
            data.put(name, id);
        }
    }

    public Map<String, Integer> getData() {
        return data;
    }
}
