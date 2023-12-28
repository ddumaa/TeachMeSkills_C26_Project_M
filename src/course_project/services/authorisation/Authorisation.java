package course_project.services.authorisation;

import course_project.session.Session;
import course_project.storage.StorageMock;

public class Authorisation {

    public static Session doLogin(String login, String password){

        StorageMock storageMock = new StorageMock();
        String loginFromStorage = storageMock.getLogin();
        String passwordFromStorage = storageMock.getPassword();

        if (login.equals(loginFromStorage) && password.equals(passwordFromStorage)){
            System.out.println("Прошел проверку");
            return new Session();
        } else {
            System.out.println("произошла ошибка при проверке");
            return null;           //TODO закончить
        }

    }

}