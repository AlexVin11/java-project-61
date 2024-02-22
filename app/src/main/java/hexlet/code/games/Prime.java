package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Prime {
    private static String primeGameRules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    static final int STRINGSINRESULTARRAY = 3;
    static final int COLUMNSINRESULTARRAY = 2;
    static final int BORDEROFRANDOMNUMBER = 20;
    static final int STRINGSINGENERATEDARRAY = 1;
    static final int COLUMNSINGENERATEDARRAY = 2;

    public static String[][] generatingPrimeExpression() {
        Random r = new Random();
        String[][] expressionAndCorrectAnswer = new String[STRINGSINGENERATEDARRAY][COLUMNSINGENERATEDARRAY];
        int numberInQuestion = r.nextInt(BORDEROFRANDOMNUMBER) + 2;
        String processedNumberInQuestion = Integer.toString(numberInQuestion);
        expressionAndCorrectAnswer[0][0] = processedNumberInQuestion;
        boolean givenNumberIsPrime = false;
        var correctAnswer = new StringBuilder();

        for (int j = 2; j <= numberInQuestion / 2; j++) {
            if (numberInQuestion % j == 0) {
                givenNumberIsPrime = true;
                break;
            }
        }

        if (!givenNumberIsPrime) {
            correctAnswer = correctAnswer.append("yes");
        } else {
            correctAnswer = correctAnswer.append("no");
        }

        String processedCorrectAnswer = correctAnswer.toString();
        expressionAndCorrectAnswer[0][1] = processedCorrectAnswer;
        return expressionAndCorrectAnswer;
    }

    public static String[][] primeResultArrayCreating() {
        //2d massive 3 lines 2 columns
        //first column contains game expression that will be shown to user
        //second column contains correct answer
        String[][] questionAndCorrectAnswer = new String[STRINGSINRESULTARRAY][COLUMNSINRESULTARRAY];
        int i = 0;

        while (i < STRINGSINRESULTARRAY) {
            String[][] processedArray = new String[1][2];
            processedArray = generatingPrimeExpression();
            questionAndCorrectAnswer[i][0] = processedArray[0][0];
            questionAndCorrectAnswer[i][1] = processedArray[0][1];
            i++;
        }

        return questionAndCorrectAnswer;
    }

    public static void primeGameExecuting() {
        String[][] questionAndCorrectAnswer = primeResultArrayCreating();
        Engine.engine(questionAndCorrectAnswer, primeGameRules);
    }
}
