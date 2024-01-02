package course_project;

import course_project.packages.utils.Consts;
import course_project.services.reading_writing_files.ReadWritFiles;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pathFolder = scanner.nextLine();
        ReadWritFiles.readingFolders(pathFolder);
    }
}
