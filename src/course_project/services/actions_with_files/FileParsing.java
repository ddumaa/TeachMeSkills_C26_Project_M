package course_project.services.actions_with_files;

import course_project.services.validition.Validator;

import java.io.File;

public class FileParsing {
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
}
