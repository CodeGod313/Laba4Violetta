package by.vita02.lab4.parser.util;

import by.vita02.lab4.builder.ClothesBuilder;
import by.vita02.lab4.builder.ShopBuilder;
import by.vita02.lab4.builder.impl.ClothesBuilderImpl;
import by.vita02.lab4.builder.impl.ShopBuilderImpl;
import by.vita02.lab4.entity.Shop;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler {

    private static final String TAG_TOWN = "town";
    private static final String TAG_CLOTHES = "clothes";
    private static final String TAG_STREET = "street";
    private static final String TAG_FIRMA = "firma";
    private static final String TAG_ELEMENTS = "elements";
    private static final String TAG_TYPE = "type";
    private static final String TAG_MODEL = "model";
    private static final String TAG_PRICE = "price";

    private String currentTagName;
    private boolean isClothes = false;
    private boolean isElement = false;

    private ShopBuilder shopBuilder;
    private ClothesBuilder clothesBuilder;

    public SAXParserHandler() {
        shopBuilder = new ShopBuilderImpl();
        clothesBuilder = new ClothesBuilderImpl();
    }

    public Shop getShop() {
        return shopBuilder.build();
    }

    @Override
    public void startDocument() throws SAXException {
        //System.out.println("Start document ");
    }

    @Override
    public void endDocument() throws SAXException {

        //System.out.println("End document ");

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //System.out.println("Start element " + qName);
        currentTagName = qName;
        if (currentTagName.equals(TAG_CLOTHES)) {
            isClothes = true;
        } else if (currentTagName.equals(TAG_ELEMENTS)) {
            isElement = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println("End  element " + qName);
        if (qName.equals(TAG_CLOTHES)) {
            isClothes = false;
        } else if (qName.equals(TAG_ELEMENTS)) {
            isElement = false;
            shopBuilder.addClothes(clothesBuilder.build());
        }
        currentTagName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //System.out.println("characters" + new  String(ch, start, length));
        if (currentTagName == null) {
            return;
        }
        if (!isClothes && currentTagName.equals(TAG_TOWN)) {
            shopBuilder.setTown(new String(ch, start, length));
        }
        if (!isClothes && currentTagName.equals(TAG_STREET)) {
            shopBuilder.setStreet(new String(ch, start, length));
        }
        if (!isClothes && currentTagName.equals(TAG_FIRMA)) {
            shopBuilder.setFirm(new String(ch, start, length));
        }
        if (isClothes && isElement) {
            if (currentTagName.equals(TAG_TYPE)) {
                clothesBuilder.setType(new String(ch, start, length));
            }
            if (currentTagName.equals(TAG_MODEL)) {
                clothesBuilder.setModel(new String(ch, start, length));
            } else if (currentTagName.equals(TAG_PRICE)) {
                clothesBuilder.setPrice(Integer.valueOf(new String(ch, start, length)));
            }
        }
    }
}
