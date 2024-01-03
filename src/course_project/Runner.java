package course_project;

import course_project.packages.logger.Logging;
import course_project.services.reading_writing_files.ReadWritFiles;

import java.util.Date;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Logging.EXECUTION_LOG(new Date(),"Program launch\n");
        Scanner scanner = new Scanner(System.in);
        String pathFolder = scanner.nextLine();
        ReadWritFiles.readingFolders(pathFolder);
    }
}
