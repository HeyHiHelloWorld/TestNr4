package pl.kurs.zadanie03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<Integer> sampleList = List.of(1, 2, 2, 3, 4, 100, 100, 21, 200, 60);
        List<Integer> shortSampleList = List.of(1, 2, 2, 3);
        List<Integer> sampleModifiableList = new ArrayList<>();
        sampleModifiableList.add(1);
        sampleModifiableList.add(5);
        sampleModifiableList.add(2);
        sampleModifiableList.add(34);
        sampleModifiableList.add(333);
        sampleModifiableList.add(23);
        sampleModifiableList.add(10);
        sampleModifiableList.add(null);

        System.out.println(getFiveMaxElementsFromList(sampleList));
        System.out.println(getFiveMaxElementsFromList(shortSampleList));
        System.out.println(getFiveMaxElementsFromList(sampleModifiableList));
    }

    public static List<Integer> getFiveMaxElementsFromList(List<Integer> numbers) {
        return Optional.ofNullable(numbers)
                .filter(s -> s.size() >= 5)
                .map(s -> s.stream()
                        .filter(Objects::nonNull)
                        .sorted(Comparator.reverseOrder())
                        .limit(5)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }
}
