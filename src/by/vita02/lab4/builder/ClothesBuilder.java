package by.vita02.lab4.builder;

import by.vita02.lab4.entity.Clothes;

public interface ClothesBuilder {

    void setType(String type);

    void setModel(String model);

    void setPrice(int price);

    Clothes build();
}
