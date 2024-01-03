package course_project.services.reading_writing_files;

import course_project.packages.logger.Logging;
import course_project.packages.utils.Consts;
import course_project.services.validition.Validator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Scanner;

public class ReadWritFiles {
    //метод получения пути к папке, проверке его на существование и передачи его на считывание
    public static void readingFolders() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the path to the folder");
            String pathFolderString;
            pathFolderString = scanner.nextLine();
            Path pathFolder = Paths.get(pathFolderString);
            Logging.EXECUTION_LOG(new Date(), "Getting folder path\n");
            if (Files.exists(pathFolder) && Files.isDirectory(pathFolder)) {
                Logging.EXECUTION_LOG(new Date(), "Path received -> " + pathFolder + "\n");
                File folder = new File(pathFolderString);
                listFilesForFolder(folder);
                break;
            } else {
                System.out.println("invalid folder path\n");
                Logging.EXECUTION_LOG(new Date(), "Invalid folder path: " + pathFolder + "\n");
            }
        }
    }

    //метод перебора папок для поиска файлов и передачи их дальше
    public static void listFilesForFolder(File folder) {
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                Validator.validationNameDocuments(fileEntry.getName(), String.valueOf(fileEntry));
            }
        }
    }

    //метод считывает строки в файле и отправляет их на проверку, возвращется число
    public static double readingFiles(String path){
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            double sum = 0;
            String line = reader.readLine();
            Logging.EXECUTION_LOG(new Date(),"Start reading file -> " + path + "\n");
            while (line != null) {
                sum = Validator.searchLineWithOrder(line);
                line = reader.readLine();
            }
            Logging.EXECUTION_LOG(new Date(), "End of file reading\n");
            return sum;
        } catch (FileNotFoundException e) {
            Logging.ERROR_LOG(new Date(), e.getMessage());
        } catch (IOException e) {
            Logging.ERROR_LOG(new Date(), e.getMessage());
        }
        return 0;
    }

    //метод записи в фаил statistics
    public static void writingFiles (String line, String line2, String line3, String line4){
        try {
            String message = line + "\n" + line2 + "\n" + line3 + "\n" + line4;
            Files.write(Paths.get(Consts.STATISTIC_WRIT_PATH), message.getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            Logging.ERROR_LOG(new Date(), e.getMessage());
        }
    }
}