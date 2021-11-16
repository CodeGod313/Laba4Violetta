package by.vita02.lab4.entity;

import java.util.List;
import java.util.StringJoiner;

public class Shop {
    private String town;
    private String street;
    private String firm;
    private List<Clothes> clothesList;

    public Shop() {
    }

    public Shop(String town, String street, String firm, List<Clothes> clothesList) {
        this.town = town;
        this.street = street;
        this.firm = firm;
        this.clothesList = clothesList;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public void setClothes(List<Clothes> clothesList) {
        this.clothesList = clothesList;
    }

    public String getTown() {
        return town;
    }

    public String getStreet() {
        return street;
    }

    public String getFirm() {
        return firm;
    }

    public List<Clothes> getClothes() {
        return clothesList;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Shop.class.getSimpleName() + "[", "]")
                .add("town='" + town + "'")
                .add("street='" + street + "'")
                .add("firm='" + firm + "'")
                .add("clothesList=" + clothesList)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        if (town != null ? !town.equals(shop.town) : shop.town != null) return false;
        if (street != null ? !street.equals(shop.street) : shop.street != null) return false;
        if (firm != null ? !firm.equals(shop.firm) : shop.firm != null) return false;
        return clothesList != null ? clothesList.equals(shop.clothesList) : shop.clothesList == null;
    }

    @Override
    public int hashCode() {
        int result = town != null ? town.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (firm != null ? firm.hashCode() : 0);
        result = 31 * result + (clothesList != null ? clothesList.hashCode() : 0);
        return result;
    }
}


