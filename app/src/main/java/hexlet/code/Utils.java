package hexlet.code;

import java.util.Random;

public class Utils {
    public static int generateRandomInt(int max) {
        //random number will be generated from [0 to (max -1)];
        Random r = new Random();
        return r.nextInt(max);
    }

    public static int generateRandomInt(int min, int max) {
        //random number will be generated from [min to max];
        return (int) (Math.random() * (max - min)) + min;
    }
}
