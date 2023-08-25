package edu.nick.ws.shared;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Utils {
    public String generateRandomString(int length) {
        // generate a random string of length 30
        String randomString = java.util.UUID.randomUUID().toString();
        return randomString.substring(0, length);
    }

    // generate a random alphanumeric user id of length 30
    public String generateUserId(int length) {
        return generateRandomString(length);
    }

    public static String generateRandomUserId(int length) {
        // Create a random number generator.
        Random random = new Random();

        // Create a string builder to hold the random alphanumeric characters.
        StringBuilder sb = new StringBuilder();

        // Generate random characters and append them to the string builder.
        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt(62) + 65); // 62 is the number of alphanumeric characters (26 letters + 10 digits + 26 letters).
            sb.append(c);
        }

        // Return the random alphanumeric string.
        return sb.toString();
    }
}
