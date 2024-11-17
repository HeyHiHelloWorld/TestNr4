package pl.kurs.zadanie02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilesCounterService {

    public static void countJavaFilesByDayOfWeek(List<File> fileList) {
        fileList.stream()
                .collect(Collectors.groupingBy(FilesCounterService::getCreationDayOfWeekFromFile, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map::ofEntries)
                .forEach(System.out::println);
    }

    public static DayOfWeek getCreationDayOfWeekFromFile(File file) {
        DayOfWeek creationDay = null;
        try {
            BasicFileAttributes bfa = Files.readAttributes(Paths.get(file.getPath()), BasicFileAttributes.class);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(bfa.creationTime().toInstant(), ZoneId.systemDefault());
            creationDay = localDateTime.getDayOfWeek();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return creationDay;
    }

    public static void findJavaFiles(File file, List<File> list) {
        if (file.isDirectory()) {
            File[] filesArray = file.listFiles();
            for (File f : filesArray) {
                findJavaFiles(f, list);
            }
        } else if (file.getName().endsWith(".java")) {
            list.add(file);
        }
    }
}
