package course_project.services.coder;

import java.util.Base64;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Coder {

    //Method to encrypt sensitive user information using Base64 class
    public static String code(String input){


        String encodedString = Base64.getEncoder().encodeToString(input.getBytes());
        String result = addSalt(encodedString);
        return result;

    }

    //Method to decrypt sensitive user information using Base64 class
    public static String decode(String input){

        byte[] decodedBytes = Base64.getDecoder().decode(input);

        if (decodedBytes.length >= 20){

            decodedBytes = Arrays.copyOfRange(decodedBytes, 10, decodedBytes.length - 10);

        } else {

            System.out.println("The entered data cannot be encoded due to insufficient bytes.");

        }

        String decoded = new String(decodedBytes);
        return decoded;

    }

    //A method that enhances the security of encrypted sensitive user information
    private static String addSalt(String input){

        String symbols = "abcdefghijklmnopqrstuvwxyz0123456789";
        String salt = new Random().ints(10, 0, symbols.length())
                                       .mapToObj(symbols::charAt)
                                       .map(Object::toString)
                                       .collect(Collectors.joining());

        String result = salt + input + salt;
        return result;

    }

}