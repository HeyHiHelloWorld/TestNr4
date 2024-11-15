package pl.kurs.zadanie02;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilesCounterRunner {
    public static void main(String[] args) {
        List<File> marcinJavaFiles = new ArrayList<>();
        FilesCounterService.findJavaFiles(new File("C:\\Users\\Marcin\\IdeaProjects"), marcinJavaFiles);

        FilesCounterService.countJavaFilesByDayOfWeek(marcinJavaFiles);

//        {MONDAY=93}
//        {TUESDAY=85}
//        {WEDNESDAY=260}
//        {THURSDAY=84}
//        {FRIDAY=68}
//        {SATURDAY=68}
//        {SUNDAY=97}
    }

}