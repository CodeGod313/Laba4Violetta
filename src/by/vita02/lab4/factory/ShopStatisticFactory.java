package by.vita02.lab4.factory;

import by.vita02.lab4.entity.Shop;
import by.vita02.lab4.entity.ShopStatistic;

public interface ShopStatisticFactory {
    ShopStatistic createShopStatistic(Shop shop);
}
