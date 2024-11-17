package pl.kurs.zadanie01.service;

import pl.kurs.zadanie01.data.Cloth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Wardrobe implements Iterable<Cloth> {
    private List<Cloth> clothList;

    private Wardrobe() {
        this.clothList = new ArrayList<>();
    }

    public static Wardrobe create() {
        return new Wardrobe();
    }

    public void addClothes(Cloth... clothes) {
        Collections.addAll(clothList, clothes);
    }

    public List<Cloth> getClothList() {
        return clothList;
    }

    @Override
    public String toString() {
        return "Wardrobe{" +
                "clothList=" + clothList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wardrobe wardrobe = (Wardrobe) o;
        return Objects.equals(clothList, wardrobe.clothList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clothList);
    }

    @Override
    public Iterator<Cloth> iterator() {
        return clothList.iterator();
    }

}