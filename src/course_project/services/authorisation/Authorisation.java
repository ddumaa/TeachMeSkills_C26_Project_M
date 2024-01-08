package course_project.services.authorisation;

import course_project.services.coder.Coder;
import course_project.services.session.Session;
import course_project.storage.StorageMock;

import java.util.Date;

import static course_project.packages.logger.Logging.EXECUTION_LOG;

/**Class that compares user input
 * with the data in our database and determining
 * start a new session or not
 */

public class Authorisation {

    public static Session doLogin(String login, String password){

        StorageMock storageMock = new StorageMock();
        String loginFromStorage = Coder.decode(storageMock.getLogin());
        String passwordFromStorage = Coder.decode(storageMock.getPassword());

        if (login.equals(loginFromStorage) && password.equals(passwordFromStorage)){

            System.out.println("User authorization was successful");
            EXECUTION_LOG(new Date(), "The user has successfully logged in.");
            return new Session();

        } else {

            System.out.println("The user is not authorized");
            EXECUTION_LOG(new Date(), "The user was unable to log in.");
            return null;

        }

    }

}
