package by.vita02.lab4.builder.impl;


import by.vita02.lab4.builder.ShopBuilder;
import by.vita02.lab4.entity.Clothes;
import by.vita02.lab4.entity.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopBuilderImpl implements ShopBuilder {

    private String town;
    private String street;
    private String firm;
    private List<Clothes> clothesList;

    public ShopBuilderImpl() {
        clothesList = new ArrayList<>();
    }

    @Override
    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public void setFirm(String firm) {
        this.firm = firm;
    }

    @Override
    public void addClothes(Clothes clothes) {
        clothesList.add(clothes);
    }

    @Override
    public Shop build() {
        return new Shop(town, street, firm, clothesList);
    }
}
