package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final String EVENGAMERULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    static final int MAXRANDOMNUMBER = 100;
    static final int MINRANDOMNUMBER = 1;
    static final int STRINGSINGENERATEDARRAY = 1;
    static final int COLUMNSINGENERATEDARRAY = 2;

    public static boolean isEven(int randomNumber) {
        return (randomNumber % 2) == 0;
    }

    public static String[][] evenArrayCreating() {
        String[][] questionAndCorrectAnswer = new String[STRINGSINGENERATEDARRAY][COLUMNSINGENERATEDARRAY];
        int randomNumber = Utils.generateRandomInt(MINRANDOMNUMBER, MAXRANDOMNUMBER);
        String processedRandomNumber = Integer.toString(randomNumber);
        boolean isEven = isEven(randomNumber);
        String correctAnswer = "";
        if (isEven) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "no";
        }
        questionAndCorrectAnswer[0][0] = processedRandomNumber;
        questionAndCorrectAnswer[0][1] = correctAnswer;
        return questionAndCorrectAnswer;
    }

    public static void evenGameExecuting() {
        String[][] questionAndCorrectAnswer = new String[Engine.GAMESTOWIN][COLUMNSINGENERATEDARRAY];
        for (int i = 0; i < Engine.GAMESTOWIN; i++) {
            String[][] processedArray = evenArrayCreating();
            questionAndCorrectAnswer[i][0] = processedArray[0][0];
            questionAndCorrectAnswer[i][1] = processedArray[0][1];
        }
        Engine.engine(questionAndCorrectAnswer, EVENGAMERULES);
    }
}
