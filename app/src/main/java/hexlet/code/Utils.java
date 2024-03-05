package hexlet.code;

import java.util.Random;

public class Utils {
    public static int generateRandomInt(int max) {
        Random r = new Random();
        return r.nextInt(max);
    }

    public static int generateRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }
}
