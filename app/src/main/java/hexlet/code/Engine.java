package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int GAMESTOWIN = 3;

    public static void engine(String[][] arguments, String gameRules) {
        Scanner scanner = new Scanner(System.in);
        String brainGamesGreetingMessage = "Welcome to the Brain Games!\nMay i have your name? ";
        String userName = "";
        String userAnswer = "";
        String answerRequest = "Your answer: ";
        String correctAnswerNotification = "Correct!";
        System.out.print(brainGamesGreetingMessage);
        userName += scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(gameRules);
        for (int i = 0; i < GAMESTOWIN; i++) {
            System.out.println("Question: " + arguments[i][0]);
            System.out.print(answerRequest);
            userAnswer = scanner.next();
            if (userAnswer.equalsIgnoreCase(arguments[i][1])) {
                System.out.println(correctAnswerNotification);
            }
            if (!userAnswer.equalsIgnoreCase(arguments[i][1])) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was "
                        + "'" + arguments[i][1] + "'.");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
            if (i == GAMESTOWIN) {
                System.out.println("Congratulations, " + userName + "!");
                break;
            }
        }
    }
}
