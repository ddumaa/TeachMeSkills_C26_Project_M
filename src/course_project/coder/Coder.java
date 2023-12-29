package course_project.coder;

import java.util.Base64;
import java.util.Random;
import java.util.stream.Collectors;

public class Coder {

    public static String code(String input){

        String encodedString = Base64.getEncoder().encodeToString(input.getBytes());
        String result = addSalt(encodedString);
        return result;

    }

    public static String decode(String input){

        byte[] decodedBytes = Base64.getDecoder().decode(input.substring(10));
        String decoded = new String(decodedBytes);  //TODO дописать декодер для расшифровки соли
        return decoded;

    }

    private static String addSalt(String input){

        String symbols = "abcdefghijklmnopqrstuvwxyz0123456789";
        String salt = new Random().ints(10, 0, symbols.length())
                                       .mapToObj(symbols::charAt)
                                       .map(Object::toString)
                                       .collect(Collectors.joining());

        String result = salt + input;          //TODO добавить более надеждую соль
        return result;

    }

}
