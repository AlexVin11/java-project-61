package hexlet.code.games;

import java.util.Random;

public class Utils {
    public static int generateRandomInt(int max) {
        //random number will be generated from [0 to (max -1)];
        Random r = new Random();
        return r.nextInt(max);
    }
}
