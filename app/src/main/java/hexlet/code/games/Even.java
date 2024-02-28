package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final String EVENGAMERULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    static final int MAXRANDOMNUMBER = 100;
    static final int MINRANDOMNUMBER = 1;
    static final int STRINGSINGENERATEDARRAY = 1;
    static final int COLUMNSINGENERATEDARRAY = 2;
    public static String generatingCorrectEvenAnswer(int randomNumber) {

        boolean isEvenRandomNumber = (randomNumber % 2) == 0;
        String correctAnswer = "";

        if (isEvenRandomNumber) {
            correctAnswer += "yes";
        } else {
            correctAnswer += "no";
        }

        return correctAnswer;
    }

    public static String[][] evenArrayCreating() {
        //2d massive 1 line 2 columns
        //first column contains game expression that will be shown to user
        //second column contains correct answer
        String[][] questionAndCorrectAnswer = new String[STRINGSINGENERATEDARRAY][COLUMNSINGENERATEDARRAY];

        int randomNumber = Utils.generateRandomInt(MINRANDOMNUMBER, MAXRANDOMNUMBER);
        String processedRandomNumber = Integer.toString(randomNumber);
        String correctAnswer = generatingCorrectEvenAnswer(randomNumber);
        questionAndCorrectAnswer[0][0] = processedRandomNumber;
        questionAndCorrectAnswer[0][1] = correctAnswer;

        return questionAndCorrectAnswer;
    }

    public static void evenGameExecuting() {
        String[][] questionAndCorrectAnswer = new String[Engine.GAMESTOWIN][COLUMNSINGENERATEDARRAY];
        int i = 0;

        while (i < Engine.GAMESTOWIN) {
            String[][] processedArray = evenArrayCreating();
            questionAndCorrectAnswer[i][0] = processedArray[0][0];
            questionAndCorrectAnswer[i][1] = processedArray[0][1];
            i++;
        }

        Engine.engine(questionAndCorrectAnswer, EVENGAMERULES);
    }
}
