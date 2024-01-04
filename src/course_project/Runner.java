package course_project;

import course_project.packages.logger.Logging;
import course_project.services.actions_with_files.WritFiles;
import course_project.services.validition.ValidationFolderExistence;

import java.util.Date;

public class Runner {
    public static void main(String[] args) {
        Logging.EXECUTION_LOG(new Date(),"Program launch\n");
        ValidationFolderExistence.checkPath();
        WritFiles.writingFiles();
        Logging.EXECUTION_LOG(new Date(),"Program end\n");
    }
}