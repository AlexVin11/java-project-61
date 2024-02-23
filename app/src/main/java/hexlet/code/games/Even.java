package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Even {
    private static final String EVENGAMERULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    static final int STRINGSINRESULTARRAY = 3;
    static final int COLUMNSINRESULTARRAY = 2;
    static final int MAXRANDOMNUMBERBORER = 100;
    static final int STRINGSINGENERATEDARRAY = 1;
    static final int COLUMNSINGENERATEDARRAY = 2;
    public static String[][] generatingEvenExpression() {
        Random r = new Random();
        String[][] expressionAndCorrectAnswer = new String[STRINGSINGENERATEDARRAY][COLUMNSINGENERATEDARRAY];
        //random number from 1 to 100 generating
        int randomNumber = r.nextInt(MAXRANDOMNUMBERBORER) + 1;
        //number to string convertation
        String processedRandomNumber = Integer.toString(randomNumber);
        boolean isEvenRandomNumber = (randomNumber % 2) == 0;
        String correctAnswer = "";

        if (isEvenRandomNumber) {
            correctAnswer += "yes";
        } else {
            correctAnswer += "no";
        }

        expressionAndCorrectAnswer[0][0] = processedRandomNumber;
        expressionAndCorrectAnswer[0][1] = correctAnswer;
        return expressionAndCorrectAnswer;
    }

    public static String[][] evenResultArrayCreating() {
        //2d massive 3 lines 2 columns
        //first column contains game expression that will be shown to user
        //second column contains correct answer
        String[][] questionAndCorrectAnswer = new String[STRINGSINRESULTARRAY][COLUMNSINRESULTARRAY];
        int i = 0;

        while (i < STRINGSINRESULTARRAY) {
            String[][] processedArray = new String[1][2];
            processedArray = generatingEvenExpression();
            questionAndCorrectAnswer[i][0] = processedArray[0][0];
            questionAndCorrectAnswer[i][1] = processedArray[0][1];
            i++;
        }

        return questionAndCorrectAnswer;
    }

    public static void evenGameExecuting() {
        String[][] questionAndCorrectAnswer = evenResultArrayCreating();
        Engine.engine(questionAndCorrectAnswer, EVENGAMERULES);
    }
}
