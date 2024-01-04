package course_project;

import course_project.packages.logger.Logging;
import course_project.services.validition.ValidationFolderExistence;

import java.util.Date;

public class Runner {
    public static void main(String[] args) {
        Logging.EXECUTION_LOG(new Date(),"Program launch\n");
        ValidationFolderExistence.checkPath();
        Logging.EXECUTION_LOG(new Date(),"Program end\n");
    }
}