package course_project.services.session;

import course_project.packages.logger.Logging;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.stream.Collectors;

public class Session {
    private static String accessToken;
    private static Date expDate;

    //Method that initializes the start of a session
    public Session() {

        setAccessToken();
        setExpDate();

        Logging.EXECUTION_LOG(new Date(), "Session started.\n");

    }

    //Method that generates an access token
    private static void setAccessToken() {
        String symbols = "abcdefghijklmnopqrstuvwxyz0123456789";
        accessToken = new Random().ints(16, 0, symbols.length())
                .mapToObj(symbols::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    //Method that sets the session timer
    private static void setExpDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, 10);
        expDate = calendar.getTime();
    }

    //Method for checking active session
    public static boolean isSessionAlive() {
        if (getAccessToken().length() == 16 && getExpDate().after(new Date())) {
            return true;
        } else {
            Logging.EXECUTION_LOG(new Date(), "Session ended." + "\n");
            return false;
        }
    }

    public static String getAccessToken () {
        return accessToken;
    }

    public static Date getExpDate () {
        return expDate;
    }

}

