package by.vita02.lab4.main;

import by.vita02.lab4.entity.Shop;
import by.vita02.lab4.entity.ShopStatistic;
import by.vita02.lab4.factory.ShopStatisticFactory;
import by.vita02.lab4.factory.impl.ShopStatisticFactoryImpl;
import by.vita02.lab4.parser.ShopParserDOM;
import by.vita02.lab4.parser.ShopParserSax;

public class Main {
    public static void main(String[] args) {
        ShopParserDOM parserDOM = new ShopParserDOM();
        ShopParserSax shopParserSax = new ShopParserSax();
        Shop shop = parserDOM.parse();
        System.out.println(shop);
        ShopStatisticFactory shopStatisticFactory = new ShopStatisticFactoryImpl();
        ShopStatistic shopStatistic = shopStatisticFactory.createShopStatistic(shop);
        System.out.println(shopStatistic);
    }
}


        




