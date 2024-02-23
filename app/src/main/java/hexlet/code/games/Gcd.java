package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Gcd {
    private static final String GCDGAMERULES = "Find the greatest common divisor of given numbers.";
    static final int STRINGSINRESULTARRAY = 3;
    static final int COLUMNSINRESULTARRAY = 2;
    static final int BORDEROFRANDOMNUMBER = 20;
    static final int STRINGSINGENERATEDARRAY = 1;
    static final int COLUMNSINGENERATEDARRAY = 2;
    public static String[][] generatingGcdExpression() {
        Random r = new Random();
        String[][] expressionAndCorrectAnswer = new String[STRINGSINGENERATEDARRAY][COLUMNSINGENERATEDARRAY];
        //random numbers from 1 to 50 generated and converted to String
        int firstNumber = r.nextInt(BORDEROFRANDOMNUMBER) + 1;
        int secondNumber = r.nextInt(BORDEROFRANDOMNUMBER) + 1;
        String processedFirstNumber = Integer.toString(firstNumber);
        String processedSecondNumber = Integer.toString(secondNumber);
        var expressionToCalculate = new StringBuilder();
        expressionToCalculate.append(processedFirstNumber);
        expressionToCalculate.append(" ");
        expressionToCalculate.append(processedSecondNumber);
        String expression = expressionToCalculate.toString();
        expressionAndCorrectAnswer[0][0] = expression;

        for (int j = 1; j <= firstNumber && j <= secondNumber; j++) {
            if (firstNumber % j == 0 && secondNumber % j == 0) {
                expressionAndCorrectAnswer[0][1] = Integer.toString(j);
            }
        }

        return expressionAndCorrectAnswer;
    }

    public static String[][] gcdResultArrayCreating() {
        //2d massive 3 lines 2 columns
        //first column contains game expression that will be shown to user
        //second column contains correct answer
        String[][] questionAndCorrectAnswer = new String[STRINGSINRESULTARRAY][COLUMNSINRESULTARRAY];
        int i = 0;

        while (i < STRINGSINRESULTARRAY) {
            String[][] processedArray = new String[1][2];
            processedArray = generatingGcdExpression();
            questionAndCorrectAnswer[i][0] = processedArray[0][0];
            questionAndCorrectAnswer[i][1] = processedArray[0][1];
            i++;
        }

        return questionAndCorrectAnswer;
    }

    public static void gcdGameExecuting() {
        String[][] questionAndCorrectAnswer = gcdResultArrayCreating();
        Engine.engine(questionAndCorrectAnswer, GCDGAMERULES);
    }
}
