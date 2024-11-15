package pl.kurs.zadanie01.app;

import pl.kurs.zadanie01.data.Cloth;
import pl.kurs.zadanie01.data.ClothSortingCriteria;
import pl.kurs.zadanie01.data.Sizes;
import pl.kurs.zadanie01.service.Wardrobe;

import java.util.Collections;

public class WardrobeRunner {
    public static void main(String[] args) {
        Wardrobe wardrobe = Wardrobe.create();
        Cloth c1 = Cloth.create("majtki", Sizes.S, 25.0);
        Cloth c2 = Cloth.create("koszula", Sizes.M, 125.0);
        Cloth c3 = Cloth.create("kurtka", Sizes.XS, 399.9);
        Cloth c4 = Cloth.create("skarpetki", Sizes.M, 15.0);
        Cloth c5 = Cloth.create("spodnie", Sizes.XL, 155.0);
        Cloth c6 = Cloth.create("koszulka", Sizes.XXXL, 39.0);

        wardrobe.addClothes();
        wardrobe.addClothes(c1, c2);
        wardrobe.addClothes(c1, c2, c3, c4);
        wardrobe.addClothes(c5, c6);
        System.out.println(wardrobe.getClothList());

        for (Cloth c : wardrobe) {
            System.out.println(c);
        }

        Cloth.setSorting(ClothSortingCriteria.SIZE);
        Cloth largest = Collections.max(wardrobe.getClothList());
        System.out.println("largest = " + largest);
        Cloth.setSorting(ClothSortingCriteria.VALUE);
        Cloth mostExpensive = Collections.max(wardrobe.getClothList());
        System.out.println("mostExpensive = " + mostExpensive);
    }
}
