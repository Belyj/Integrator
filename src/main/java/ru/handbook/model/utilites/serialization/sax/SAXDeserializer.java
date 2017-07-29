package ru.handbook.model.utilites.serialization.sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class SAXDeserializer {

    public SAXDeserializer() {
        readValue();
    }

    private void readValue() {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        Handler handler = new Handler();
        try {
            SAXParser saxParser = parserFactory.newSAXParser();
            saxParser.parse(new File("dom.xml"), handler);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Integer> data = handler.getData();
        for (Map.Entry<String, Integer> dMap : data.entrySet()) {
            System.out.println(dMap.getKey() + "    " + dMap.getValue());
        }
    }
}
