package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final String PRIMEGAMERULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    static final int MAXRANDOMNUMBER = 20;
    static final int MINRANDOMNUMBER = 1;
    static final int STRINGSINGENERATEDARRAY = 1;
    static final int COLUMNSINGENERATEDARRAY = 2;

    public static boolean isPrime(int randomNumber) {
        if (randomNumber == 1) {
            return false;
        }
        for (int j = 2; j <= Math.sqrt(randomNumber); j++) {
            if (randomNumber % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static String[][] primeArrayCreating() {
        String[][] expressionAndCorrectAnswer = new String[STRINGSINGENERATEDARRAY][COLUMNSINGENERATEDARRAY];
        int randomNumber = Utils.generateRandomInt(MINRANDOMNUMBER, MAXRANDOMNUMBER);
        String processedRandomNumber = Integer.toString(randomNumber);
        boolean correctAnswer = isPrime(randomNumber);
        String processedCorrectAnswer = "";
        expressionAndCorrectAnswer[0][0] = processedRandomNumber;
        if (correctAnswer) {
            processedCorrectAnswer = "yes";
        } else {
            processedCorrectAnswer = "no";
        }
        expressionAndCorrectAnswer[0][1] = processedCorrectAnswer;
        return expressionAndCorrectAnswer;
    }

    public static void primeGameExecuting() {
        String[][] questionAndCorrectAnswer = new String[Engine.GAMESTOWIN][COLUMNSINGENERATEDARRAY];
        for (int i = 0; i < Engine.GAMESTOWIN; i++) {
            String[][] processedArray = primeArrayCreating();
            questionAndCorrectAnswer[i][0] = processedArray[0][0];
            questionAndCorrectAnswer[i][1] = processedArray[0][1];
        }
        Engine.engine(questionAndCorrectAnswer, PRIMEGAMERULES);
    }
}
