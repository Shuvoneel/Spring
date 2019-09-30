
// Java program generate a random
// UpperCase or LowerCase or Number String

import java.util.Random;

public class RandomUpLowNum {
    static String getRandomString(int n) {

        // In Java, ASCII value of a character number between 0 and 127

        //The ASCII value of lowercase alphabets are from 97 to 122.

        //The ASCII value of uppercase alphabets are from 65 to 90.

        int lowerLimit = 0;

        int upperLimit = 127;

        Random random = new Random();

        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer(n);

        for (int i = 0; i < n; i++) {

            // take a random value between 0 and 127
            int nextRandomChar = lowerLimit
                    + (random.nextInt()
                    * (upperLimit - lowerLimit + 1));

            // append a character at the end of bs
            r.append((char) nextRandomChar);
        }

        // return the resultant string
        return r.toString();
    }

    public static void main(String[] args) {
        // size of random alphanumeric string
        int n = 7;

        // Get and display the alphanumeric string
        System.out.println(getRandomString(n));
    }
}
