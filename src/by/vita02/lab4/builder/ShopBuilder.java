package by.vita02.lab4.builder;

import by.vita02.lab4.entity.Clothes;
import by.vita02.lab4.entity.Shop;

public interface ShopBuilder {
    void setTown(String town);

    void setStreet(String street);

    void setFirm(String firm);

    void addClothes(Clothes clothes);

    Shop build();
}
