package course_project.services.actions_with_files;

import course_project.packages.logger.Logging;
import course_project.packages.utils.Consts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class WritFiles {
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
