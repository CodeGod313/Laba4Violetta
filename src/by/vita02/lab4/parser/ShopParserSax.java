package by.vita02.lab4.parser;

import by.vita02.lab4.entity.Shop;
import by.vita02.lab4.parser.util.SAXParserHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class ShopParserSax {
    public Shop parse() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParserHandler handler = new SAXParserHandler();
        SAXParser parser;
        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            System.out.println("Open sax parser  error " + e.toString());
            return null;
        }
        File file = new File("src/resources/fileDom.xml");
        try {
            parser.parse(file, handler);
        } catch (SAXException e) {
            System.out.println("Sax parsing error " + e.toString());
            return null;
        } catch (IOException e) {
            System.out.println("IO parsing error " + e.toString());
            return null;
        }
        return handler.getShop();
    }
}