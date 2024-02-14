package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Calc {
    public static String calcGameRules = "What is the result of expression?";
    public static String[][] calc() {
        Random r = new Random();
        char[] operators = {'+', '-', '*'};
        //двумерный массив содержащий 3 выражения которые будут показаны пользователю (3 строки первого столбца) для
        //вычисления и правильные ответы (второй столбец, 3 строки) с которыми нужно сверяться
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
            //здесь char элемент массива operators конвертируется в строку и добавляется в итоговую строку
            expressionForCalculate.append(Character.toString(operators[charIndexGenerator]));
            expressionForCalculate.append(" ");
            expressionForCalculate.append(processedSecondNumber);
            //сформировал итоговую строку- выражение
            String expression = expressionForCalculate.toString();
            //поместил выражение которое будет показано пользователю в массив
            questionAndCorrectAnswer[i][0] = expression;

            if (operators[charIndexGenerator] == '+') {
                resultOfExpression = firstNumber + secondNumber;
            } else if (operators[charIndexGenerator] == '-') {
                resultOfExpression = firstNumber - secondNumber;
            } else if (operators[charIndexGenerator] == '*') {
                resultOfExpression = firstNumber * secondNumber;
            }

            //вычисленное выражение перевел в строку и пометил в массив
            questionAndCorrectAnswer[i][1] = Integer.toString(resultOfExpression);
        }

        return questionAndCorrectAnswer;
    }
}
