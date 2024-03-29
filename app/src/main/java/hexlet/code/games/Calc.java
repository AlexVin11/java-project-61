package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static final String CALCGAMERULES = "What is the result of the expression?";
    static final int MAXRANDOMNUMBER = 50;
    static final int MINRANDOMNUMBER = 3;
    static final int STRINGSINGENERATEDARRAY = 1;
    static final int COLUMNSINGENERATEDARRAY = 2;
    static final char[] OPERATORS = {'+', '-', '*'};

    public static int generatingCorrectCalcAnswer(int firstNumber, int secondNumber, char operator) {
        int resultOfExpression = 0;
        switch (operator) {
            case '+' :
                resultOfExpression = firstNumber + secondNumber;
                break;
            case '-' :
                resultOfExpression = firstNumber - secondNumber;
                break;
            case '*' :
                resultOfExpression = firstNumber * secondNumber;
                break;
            default:
                System.out.println("Unknown command.");
                break;
        }
        return resultOfExpression;
    }

    public static String[][] calcArrayCreating() {
        String[][] questionAndCorrectAnswer = new String[STRINGSINGENERATEDARRAY][COLUMNSINGENERATEDARRAY];
        var firstNumber = Utils.generateRandomInt(MINRANDOMNUMBER, MAXRANDOMNUMBER);
        var secondNumber = Utils.generateRandomInt(MINRANDOMNUMBER, MAXRANDOMNUMBER);
        var charIndexGenerator = Utils.generateRandomInt(OPERATORS.length);
        char chosenOperator = OPERATORS[charIndexGenerator];
        String processedFirstNumber = Integer.toString(firstNumber);
        String processedSecondNumber = Integer.toString(secondNumber);
        var expressionForCalculate = new StringBuilder();
        expressionForCalculate.append(processedFirstNumber);
        expressionForCalculate.append(" ");
        expressionForCalculate.append(Character.toString(OPERATORS[charIndexGenerator]));
        expressionForCalculate.append(" ");
        expressionForCalculate.append(processedSecondNumber);
        String expression = expressionForCalculate.toString();
        int correctAnswer = generatingCorrectCalcAnswer(firstNumber, secondNumber, chosenOperator);
        String processedCorrectAnswer = String.valueOf(correctAnswer);
        questionAndCorrectAnswer[0][0] = expression;
        questionAndCorrectAnswer[0][1] = processedCorrectAnswer;
        return questionAndCorrectAnswer;
    }

    public static void calcGameExecuting() {
        String[][] questionAndCorrectAnswer = new String[Engine.GAMESTOWIN][COLUMNSINGENERATEDARRAY];
        for (int i = 0; i < Engine.GAMESTOWIN; i++) {
            String[][] processedArray = calcArrayCreating();
            questionAndCorrectAnswer[i][0] = processedArray[0][0];
            questionAndCorrectAnswer[i][1] = processedArray[0][1];
        }
        Engine.engine(questionAndCorrectAnswer, CALCGAMERULES);
    }
}
