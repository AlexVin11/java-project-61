package hexlet.code;

import java.util.Scanner;

public class Engine {
    //why is like that??
    static final int GAMESTOWIN = 3;

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

        while (winningCount < GAMESTOWIN) {

            for (; i < GAMESTOWIN; i++) {
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

        if (winningCount == GAMESTOWIN) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was "
                    + "'" + arguments[i][1] + "'.");
            System.out.println("Let's try again, " + userName + "!");
        }
    }
}
