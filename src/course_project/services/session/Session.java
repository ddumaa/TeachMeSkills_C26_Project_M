package course_project.services.session;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.stream.Collectors;

public class Session {

    private String accessToken;
    private Date expDate;

    public Session() {
        setAccessToken();
        this.expDate = expDate;

    }

    public boolean isSessionAlive(){

        if (this.accessToken.length() == 16 &&
                this.expDate.after(new Date())){
            return true;
        } else {
            return false;
        }

    }

    private void setAccessToken(){

        String symbols = "abcdefghijklmnopqrstuvwxyz0123456789";
        this.accessToken = new Random().ints(10, 0, symbols.length())
                .mapToObj(symbols::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());

    }

    private void setExpDate(){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, 10);
        this.expDate = calendar.getTime();

    }

}
