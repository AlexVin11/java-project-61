package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Gcd {
    private static final String GCDGAMERULES = "Find the greatest common divisor of given numbers.";
    static final int MAXRANDOMNUMBER = 20;
    static final int MINRANDOMNUMBER = 1;
    static final int STRINGSINGENERATEDARRAY = 1;
    static final int COLUMNSINGENERATEDARRAY = 2;

    public static int generatingCorrectGcdAnswer(int firstNumber, int secondNumber) {
        int gcdOfNumbers = 1;
        for (int j = 1; j <= firstNumber && j <= secondNumber; j++) {
            if (firstNumber % j == 0 && secondNumber % j == 0) {
                gcdOfNumbers = j;
            }
        }
        return gcdOfNumbers;
    }

    public static String[][] gcdArrayCreating() {
        String[][] expressionAndCorrectAnswer = new String[STRINGSINGENERATEDARRAY][COLUMNSINGENERATEDARRAY];
        int firstNumber = Utils.generateRandomInt(MINRANDOMNUMBER, MAXRANDOMNUMBER);
        int secondNumber = Utils.generateRandomInt(MINRANDOMNUMBER, MAXRANDOMNUMBER);
        String processedFirstNumber = Integer.toString(firstNumber);
        String processedSecondNumber = Integer.toString(secondNumber);
        int correctAnswer = generatingCorrectGcdAnswer(firstNumber, secondNumber);
        String processedCorrectAnswer = Integer.toString(correctAnswer);
        var expressionToCalculate = new StringBuilder();
        expressionToCalculate.append(processedFirstNumber);
        expressionToCalculate.append(" ");
        expressionToCalculate.append(processedSecondNumber);
        String expression = expressionToCalculate.toString();
        expressionAndCorrectAnswer[0][0] = expression;
        expressionAndCorrectAnswer[0][1] = processedCorrectAnswer;
        return expressionAndCorrectAnswer;
    }

    public static void gcdGameExecuting() {
        String[][] questionAndCorrectAnswer = new String[Engine.GAMESTOWIN][COLUMNSINGENERATEDARRAY];
        for (int i = 0; i < Engine.GAMESTOWIN; i++) {
            String[][] processedArray = gcdArrayCreating();
            questionAndCorrectAnswer[i][0] = processedArray[0][0];
            questionAndCorrectAnswer[i][1] = processedArray[0][1];
        }
        Engine.engine(questionAndCorrectAnswer, GCDGAMERULES);
    }
}
