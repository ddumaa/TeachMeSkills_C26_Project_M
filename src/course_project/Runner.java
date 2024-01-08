package course_project;

import course_project.packages.logger.Logging;
import course_project.services.actions_with_files.WritFiles;
import course_project.services.authorisation.Authorisation;
import course_project.services.session.Session;
import course_project.services.validition.ValidationFolderExistence;

import java.util.Date;

public class Runner {
    public static void main(String[] args) {
        Logging.EXECUTION_LOG(new Date(),"Program launch\n");

        Session session = Authorisation.doLogin();
        if (session != null) {
            if (Session.isSessionAlive()) {
                ValidationFolderExistence.checkPath();
                WritFiles.writingFiles();
            } else {
                System.out.println("OPS");
            }
        } else {
            System.out.println("OOOOPPPPPSSSS");
        }
        Logging.EXECUTION_LOG(new Date(),"Program end\n");
    }
}