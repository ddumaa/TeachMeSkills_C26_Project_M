package course_project.services.reading_writing_files;

import course_project.packages.logger.Logging;
import course_project.packages.utils.Consts;
import course_project.services.validition.Validator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class ReadWritFiles {
    //метод получения пути к папке и передачи его дальше
    public static void readingFolders(String myFolder) {
        Logging.EXECUTION_LOG(new Date(), "Getting folder path\n");
        File folder = new File(myFolder);
        Logging.EXECUTION_LOG(new Date(), "Path received -> " + myFolder + "\n");
        listFilesForFolder(folder);
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
            //Logging.EXECUTION_LOG(new Date(), "data was successfully written along the path -> " + Consts.STATISTIC_WRIT_PATH);
        } catch (IOException e) {
            Logging.ERROR_LOG(new Date(), e.getMessage());
        }
    }
}
