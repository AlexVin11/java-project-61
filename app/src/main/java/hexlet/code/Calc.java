package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Calc {
    public static void calc(String userName) {
        System.out.println("What is the result of expression?");
        Random r = new Random();
        var winningCount = 0;
        char[] operator = {'+', '-', '*'};

        while (winningCount < 3) {
            var firstNumber = r.nextInt(50) + 1;
            var secondNumber = r.nextInt(50) + 1;
            var charIndexGenerator = r.nextInt(3);
            int resultOfExpression = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Question: " + firstNumber + operator[charIndexGenerator] + secondNumber);
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (operator[charIndexGenerator] == '+') {
                resultOfExpression = firstNumber + secondNumber;
            } else if (operator[charIndexGenerator] == '-') {
                resultOfExpression = firstNumber - secondNumber;
            } else if (operator[charIndexGenerator] == '*') {
                resultOfExpression = firstNumber * secondNumber;
            }

            if (userAnswer == resultOfExpression) {
                winningCount += 1;
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was '" + resultOfExpression + "'");
                break;
            }
        }

        if (winningCount == 3) {
            System.out.println("Congratulation, " + userName + " !");
        } else {
            System.out.println("Let`s try again " + userName);
        }
    }
}
