package ru.handbook.model.utilites.validator;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidator {

    SchemaFactory schemaFactory;
    File file;
    public boolean validateXMLSchema(String xsd, String xml) {
        file = new File(xsd);
        try {
            createValidator().validate(new StreamSource(new File(xml)));
            return true;
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private SchemaFactory createSchemaFactory() {
        return SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    }

    private Schema createSchema() {
        try {
            return createSchemaFactory().newSchema(file);
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Validator createValidator() {
        return createSchema().newValidator();
    }
}
