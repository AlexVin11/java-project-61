package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calc {
    private static final String CALCGAMERULES = "What is the result of the expression?";
    static final int STRINGSINRESULTARRAY = 3;
    static final int COLUMNSINRESULTARRAY = 2;
    static final int BORDEROFNUMBER = 50;
    static final int STRINGSINGENERATEDARRAY = 1;
    static final int COLUMNSINGENERATEDARRAY = 2;

    public static String[][] generatingCalcExpression() {
        Random r = new Random();
        char[] operators = {'+', '-', '*'};
        int operatorsLength = operators.length;
        var firstNumber = r.nextInt(BORDEROFNUMBER) + 1;
        var secondNumber = r.nextInt(BORDEROFNUMBER) + 1;
        var charIndexGenerator = r.nextInt(operatorsLength);
        int resultOfExpression = 0;
        String processedFirstNumber = Integer.toString(firstNumber);
        String processedSecondNumber = Integer.toString(secondNumber);
        var expressionForCalculate = new StringBuilder();
        expressionForCalculate.append(processedFirstNumber);
        expressionForCalculate.append(" ");
        //char element of operators converted in string and appended
        expressionForCalculate.append(Character.toString(operators[charIndexGenerator]));
        expressionForCalculate.append(" ");
        expressionForCalculate.append(processedSecondNumber);
        //final expression
        String expression = expressionForCalculate.toString();
        String[][] expressionAndCorrectAnswer = new String[STRINGSINGENERATEDARRAY][COLUMNSINGENERATEDARRAY];

        if (operators[charIndexGenerator] == '+') {
            resultOfExpression = firstNumber + secondNumber;
        } else if (operators[charIndexGenerator] == '-') {
            resultOfExpression = firstNumber - secondNumber;
        } else if (operators[charIndexGenerator] == '*') {
            resultOfExpression = firstNumber * secondNumber;
        }
        expressionAndCorrectAnswer[0][0] = expression;
        expressionAndCorrectAnswer[0][1] = Integer.toString(resultOfExpression);

        return expressionAndCorrectAnswer;
    }

    public static String[][] calcResultArrayCreating() {
        //2d massive 3 lines 2 columns
        //first column contains game expression that will be shown to user
        //second column contains correct answer
        String[][] questionAndCorrectAnswer = new String[STRINGSINRESULTARRAY][COLUMNSINRESULTARRAY];
        int i = 0;

        while (i < STRINGSINRESULTARRAY) {
            String[][] processedArray = new String[1][2];
            processedArray = generatingCalcExpression();
            questionAndCorrectAnswer[i][0] = processedArray[0][0];
            questionAndCorrectAnswer[i][1] = processedArray[0][1];
            i++;
        }

        return questionAndCorrectAnswer;
    }

    public static void calcGameExecuting() {
        String[][] questionAndCorrectAnswer = calcResultArrayCreating();
        Engine.engine(questionAndCorrectAnswer, CALCGAMERULES);
    }
}
