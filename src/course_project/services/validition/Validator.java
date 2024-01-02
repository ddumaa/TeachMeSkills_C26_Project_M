package course_project.services.validition;

import course_project.packages.utils.Consts;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

public class Validator {
    public static String path;
    public static void validationNameDocuments (String nameFile) {
        if (nameFile.endsWith(Consts.fileExtension)) {
            //TODO сделать чекер нужных файлов

        } else {
            //невалидные файлы перемещаются
            File sourceFile = new File(path);
            File destinationFolder = new File(Consts.DESTINATION_FOLDER);
            try {
                Path sourcePath = sourceFile.toPath();
                Path destinationPath = new File(destinationFolder, sourceFile.getName()).toPath();
                Files.move(sourcePath, destinationPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
