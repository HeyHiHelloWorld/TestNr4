package pl.kurs.zadanie01.data;

import java.util.Objects;

public class Cloth implements Comparable<Cloth> {
    private String name;
    private Sizes size;
    private double price;
    private static ClothSortingCriteria defaultSortingCriteria = ClothSortingCriteria.SIZE;

    private Cloth(String name, Sizes size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public static Cloth create(String name, Sizes size, double price) {
        return new Cloth(name, size, price);
    }

    public static void setSorting(ClothSortingCriteria criteria) {
        defaultSortingCriteria = criteria;
    }


    @Override
    public String toString() {
        return "Cloth{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cloth cloth = (Cloth) o;
        return Double.compare(cloth.price, price) == 0 && Objects.equals(name, cloth.name) && size == cloth.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, price);
    }


    @Override
    public int compareTo(Cloth o) {
        int largestSize = Integer.compare(size.ordinal(), o.size.ordinal());
        int highestValue = Double.compare(price, o.price);
        return defaultSortingCriteria == ClothSortingCriteria.SIZE ? largestSize : highestValue;
    }
}
