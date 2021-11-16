package by.vita02.lab4.parser;



import by.vita02.lab4.builder.ClothesBuilder;
import by.vita02.lab4.builder.ShopBuilder;
import by.vita02.lab4.builder.impl.ClothesBuilderImpl;
import by.vita02.lab4.builder.impl.ShopBuilderImpl;
import by.vita02.lab4.entity.Clothes;
import by.vita02.lab4.entity.Shop;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ShopParserDOM {
    private static final String TAG_TOWN = "town";
    private static final String TAG_CLOTHES = "clothes";
    private static final String TAG_STREET = "street";
    private static final String TAG_FIRM = "firm";
    private static final String TAG_ELEMENTS = "elements";
    private static final String TAG_TYPE = "type";
    private static final String TAG_MODEL = "model";
    private static final String TAG_PRICE = "price";

    public Shop parse() {
        ShopBuilder shopBuilder = new ShopBuilderImpl();
        Document doc;
        try {
            doc = buildDocument();
        } catch (Exception e) {
            System.out.println("Open parsing error" + e.toString());
            return null;
        }

        Node shopNode = doc.getFirstChild();
        NodeList shopChildNodes = shopNode.getChildNodes();
        Node clothesNode = null;
        for (int i = 0; i < shopChildNodes.getLength(); i++) {
            Node currentNode = shopChildNodes.item(i);
            if (currentNode.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            String textContent = currentNode.getTextContent();
            switch (currentNode.getNodeName()) {
                case TAG_TOWN -> shopBuilder.setTown(textContent);
                case TAG_STREET -> shopBuilder.setStreet(textContent);
                case TAG_FIRM -> shopBuilder.setFirm(textContent);
                case TAG_CLOTHES -> clothesNode = currentNode;
            }
        }
        if (clothesNode == null) {
            return null;
        }
        parsClothesList(clothesNode, shopBuilder);
        return shopBuilder.build();
    }

    private Document buildDocument() throws Exception {
        File file = new File("src/resources/fileDOM.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        return dbf.newDocumentBuilder().parse(file);
    }

    private void parsClothesList(Node clothesNode, ShopBuilder shopBuilder) {
        NodeList childClothes = clothesNode.getChildNodes();
        for (int k = 0; k < childClothes.getLength(); k++) {
            Node currentNode = childClothes.item(k);
            short nodeType = currentNode.getNodeType();
            String nodeName = currentNode.getNodeName();
            if (nodeType != Node.ELEMENT_NODE || !nodeName.equals(TAG_ELEMENTS)) {
                continue;
            }
            Clothes clothes = parseElements(childClothes.item(k));
            shopBuilder.addClothes(clothes);
        }
    }

    private Clothes parseElements(Node elementsNode) {
        ClothesBuilder clothesBuilder = new ClothesBuilderImpl();
        NodeList childElements = elementsNode.getChildNodes();
        for (int j = 0; j < childElements.getLength(); j++) {
            Node currentNode = childElements.item(j);
            if (currentNode.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            String textContent = currentNode.getTextContent();
            switch (currentNode.getNodeName()) {
                case TAG_TYPE -> clothesBuilder.setType(textContent);
                case TAG_MODEL -> clothesBuilder.setModel(textContent);
                case TAG_PRICE -> clothesBuilder.setPrice(Integer.parseInt(textContent));
            }
        }
        return clothesBuilder.build();
    }
}

