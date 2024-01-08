package course_project.services.session;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.stream.Collectors;

import static course_project.packages.logger.Logging.EXECUTION_LOG;

public class Session {

    private String accessToken;
    private Date expDate;
    private int loginAttempts;

    //Method that initializes the start of a session
    public Session() {

        setAccessToken();
        setExpDate();
        this.loginAttempts = 0;

        EXECUTION_LOG(new Date(), "Session started. Access Token: " + accessToken);

    }

    //Method that generates an access token
    private void setAccessToken() {
        String symbols = "abcdefghijklmnopqrstuvwxyz0123456789";
        this.accessToken = new Random().ints(16, 0, symbols.length())
                .mapToObj(symbols::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    //Method that sets the session timer
    private void setExpDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, 10);
        this.expDate = calendar.getTime();

    }

    //Method for checking active session
    private boolean isSessionAlive() {

        if (this.accessToken.length() == 16 &&
                this.expDate.after(new Date())) {

            return true;

        } else {

            EXECUTION_LOG(new Date(), "Session ended.");
            return false;

        }

    }

    //Method that counts the number of password attempts
    private void attemptLogin(String password) {

        if (checkPassword(password)) {

            EXECUTION_LOG(new Date(), "Password entered successfully. Access Token: " + accessToken);

        } else {

            loginAttempts++;
            EXECUTION_LOG(new Date(), "Incorrect password entered." + accessToken);

            if(loginAttempts >= 3) {

                exitSystem();

            }

        }

    }

    //A method that interrupts the program if there are more than one password entry attempt.
    private void exitSystem(){

        EXECUTION_LOG(new Date(), "The number of password attempts has been exceeded. Stopping the program.");
            System.exit(0);

    }

    //A method that checks whether a password is entered correctly
    private boolean checkPassword(String password) {

        if (password.matches(".*\\d.*") && password.length() >= 8 && "changeme123".equals(password)){

            EXECUTION_LOG(new Date(), "Password verification passed." + accessToken);
            return true;

        } else {

            EXECUTION_LOG(new Date(), "Password verification failed." + accessToken);
            return false;

        }

    }

}
