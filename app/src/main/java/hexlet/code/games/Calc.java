package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Calc {
    public static String calcGameRules = "What is the result of expression?";
    public static String[][] calc() {
        Random r = new Random();
        char[] operators = {'+', '-', '*'};
        //2d massive 3 lines 2 columns
        //first column contains game expression that will be shown to user
        //second column contains correct answer
        String[][] questionAndCorrectAnswer = new String[3][2];

        for (int i = 0; i < 3; i++) {
            var firstNumber = r.nextInt(50) + 1;
            var secondNumber = r.nextInt(50) + 1;
            var charIndexGenerator = r.nextInt(3);
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

        return questionAndCorrectAnswer;
    }
}
