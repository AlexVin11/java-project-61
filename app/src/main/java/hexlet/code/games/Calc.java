package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calc {
    private static String calcGameRules = "What is the result of the expression?";
    static final int STRINGSINARRAY = 3;
    static final int COLUMNSINARRAY = 2;
    static final int BORDEROFNUMBER = 50;
    public static void calc() {
        Random r = new Random();
        char[] operators = {'+', '-', '*'};
        int operatorsLength = operators.length;
        //2d massive 3 lines 2 columns
        //first column contains game expression that will be shown to user
        //second column contains correct answer
        String[][] questionAndCorrectAnswer = new String[STRINGSINARRAY][COLUMNSINARRAY];

        for (int i = 0; i < STRINGSINARRAY; i++) {
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
            questionAndCorrectAnswer[i][0] = expression;

            if (operators[charIndexGenerator] == '+') {
                resultOfExpression = firstNumber + secondNumber;
            } else if (operators[charIndexGenerator] == '-') {
                resultOfExpression = firstNumber - secondNumber;
            } else if (operators[charIndexGenerator] == '*') {
                resultOfExpression = firstNumber * secondNumber;
            }

            questionAndCorrectAnswer[i][1] = Integer.toString(resultOfExpression);
        }

        Engine.engine(questionAndCorrectAnswer, calcGameRules);
    }
}
