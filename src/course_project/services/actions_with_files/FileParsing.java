package course_project.services.actions_with_files;

import course_project.services.validition.ValidationNameFiles;

import java.io.File;

/**
 * Метод перебора папок для поиска файлов и передачи их дальше
 */
public class FileParsing {
    public static void listFilesForFolder(File folder) {
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                ValidationNameFiles.validatingNameDocuments(fileEntry.getName(), String.valueOf(fileEntry));
            }
        }
    }
}
