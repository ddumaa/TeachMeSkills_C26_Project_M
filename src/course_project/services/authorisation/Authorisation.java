package course_project.services.authorisation;

import course_project.packages.logger.Logging;
import course_project.services.coder.Coder;
import course_project.services.session.Session;
import course_project.storage.StorageMock;

import java.util.Date;
import java.util.Scanner;

import static course_project.packages.logger.Logging.EXECUTION_LOG;

/**Class that compares user input
 * with the data in our database and determining
 * start a new session or not
 */

public class Authorisation {

    public static Session doLogin(){

        int count = 1;
        int count2 = 3;
        Scanner scanner = new Scanner(System.in);
        String login;
        String password;

        while (true) {
            Logging.EXECUTION_LOG(new Date(), "Authorization attempt\n");
            System.out.println("Enter login");
            login = scanner.nextLine();
            System.out.println("Enter password");
            password = scanner.nextLine();
            count2--;

            StorageMock storageMock = new StorageMock();
            String loginFromStorage = Coder.decode(storageMock.getLogin());
            String passwordFromStorage = Coder.decode(storageMock.getPassword());

            if (login.equals(loginFromStorage) && password.equals(passwordFromStorage)) {

                System.out.println("Authorization was successful");
                Logging.EXECUTION_LOG(new Date(), "The user has successfully logged in.\n");
                return new Session();

            } else if (count2 >=1){
                count++;

                System.out.println("Invalid information, please try to log in again. Attempts left: " + count2);
                Logging.EXECUTION_LOG(new Date(), "The user was unable to log in. Incorrect data entered. Login attempts: " + count + "\n");

            } else {
                System.out.println("Authorization attempts exhausted");
                break;
            }
        }
        return null;
    }

}
