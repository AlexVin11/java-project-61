package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final String PRIMEGAMERULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    static final int MAXRANDOMNUMBER = 20;
    static final int MINRANDOMNUMBER = 1;
    static final int STRINGSINGENERATEDARRAY = 1;
    static final int COLUMNSINGENERATEDARRAY = 2;

    public static String generatingCorrectPrimeAnswer(int randomNumber) {

        for (int j = 2; j <= Math.sqrt(randomNumber); j++) {
            if (randomNumber % j == 0) {
                return "no";
            }
        }

        return "yes";
    }

    public static String[][] primeArrayCreating() {
        //2d massive 1 lines 2 columns
        //first column contains game expression that will be shown to user
        //second column contains correct answer
        String[][] expressionAndCorrectAnswer = new String[STRINGSINGENERATEDARRAY][COLUMNSINGENERATEDARRAY];
        int randomNumber = Utils.generateRandomInt(MINRANDOMNUMBER, MAXRANDOMNUMBER);
        String processedRandomNumber = Integer.toString(randomNumber);
        String correctAnswer = generatingCorrectPrimeAnswer(randomNumber);

        expressionAndCorrectAnswer[0][0] = processedRandomNumber;
        expressionAndCorrectAnswer[0][1] = correctAnswer;

        return expressionAndCorrectAnswer;
    }

    public static void primeGameExecuting() {
        String[][] questionAndCorrectAnswer = new String[Engine.GAMESTOWIN][COLUMNSINGENERATEDARRAY];
        int i = 0;

        while (i < Engine.GAMESTOWIN) {
            String[][] processedArray = primeArrayCreating();
            questionAndCorrectAnswer[i][0] = processedArray[0][0];
            questionAndCorrectAnswer[i][1] = processedArray[0][1];
            i++;
        }

        Engine.engine(questionAndCorrectAnswer, PRIMEGAMERULES);
    }
}
