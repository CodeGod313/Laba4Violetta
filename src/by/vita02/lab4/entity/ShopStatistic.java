package by.vita02.lab4.entity;

import java.util.StringJoiner;

public class ShopStatistic {
    private Double averagePrice;
    private String mostPresentedTypes;

    public ShopStatistic(Double averagePrice, String mostPresentedTypes) {
        this.averagePrice = averagePrice;
        this.mostPresentedTypes = mostPresentedTypes;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ShopStatistic.class.getSimpleName() + "[", "]")
                .add("averagePrice=" + averagePrice)
                .add("mostPresentedType='" + mostPresentedTypes + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopStatistic that = (ShopStatistic) o;

        if (averagePrice != null ? !averagePrice.equals(that.averagePrice) : that.averagePrice != null) return false;
        return mostPresentedTypes != null ? mostPresentedTypes.equals(that.mostPresentedTypes) : that.mostPresentedTypes == null;
    }

    @Override
    public int hashCode() {
        int result = averagePrice != null ? averagePrice.hashCode() : 0;
        result = 31 * result + (mostPresentedTypes != null ? mostPresentedTypes.hashCode() : 0);
        return result;
    }
}
