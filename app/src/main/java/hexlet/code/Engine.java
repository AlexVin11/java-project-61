package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.EvenGame;

import java.util.Scanner;

public class Engine {
    public static void engine(String[][] arguments, String gameRules) {
        Scanner scanner = new Scanner(System.in);
        int winningCount = 0;
        String brainGamesGreetingMessage = "Welcome to the Brain Games!\nMay i have your name? ";
        String userName = "";
        String userAnswer = "";
        int i = 0;
        String answerRequest = "Your answer: ";
        String correctAnswerNotification = "Correct!";

        System.out.print(brainGamesGreetingMessage);
        userName += scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(gameRules);

        while (winningCount < 3) {

            for (; i < 3; i++) {
                System.out.println("Question: " + arguments[i][0]);
                System.out.print(answerRequest);
                userAnswer = scanner.next();

                if (userAnswer.equalsIgnoreCase(arguments[i][1])) {
                    winningCount += 1;
                    System.out.println(correctAnswerNotification);
                } else {
                    break;
                }
            }

            break;
        }

        if (winningCount == 3) {
            System.out.print("Congratulation, " + userName + " !");
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was "
                    + "'" + arguments[i][1] + "'");
            System.out.print("Lets try again, " + userName + "!");
        }
    }
}
