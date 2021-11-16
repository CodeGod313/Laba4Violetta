package by.vita02.lab4.entity;

import java.util.StringJoiner;

public class Clothes {
    private String type;
    private String model;
    private int price;

    public Clothes(String type, String model, int price) {
        this.type = type;
        this.model = model;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Clothes.class.getSimpleName() + "{", "}")
                .add("type='" + type + "'")
                .add("model='" + model + "'")
                .add("price=" + price)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clothes clothes = (Clothes) o;

        if (price != clothes.price) return false;
        if (type != null ? !type.equals(clothes.type) : clothes.type != null) return false;
        return model != null ? model.equals(clothes.model) : clothes.model == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }
}
