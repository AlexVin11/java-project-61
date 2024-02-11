package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
    public static void evenGame(String userName) {
        int winningCount = 0;
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (winningCount < 3) {
            int randomNumber = r.nextInt(100) + 1;
            boolean isEvenNumber = (randomNumber % 2) == 0;
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer is: ");
            String userAnswer = scanner.next();

            if ((isEvenNumber && userAnswer.equalsIgnoreCase("yes")) ||
            ((!isEvenNumber) && userAnswer.equalsIgnoreCase("no"))) {
                winningCount += 1;
                System.out.println("Correct!");
            } else if (isEvenNumber && userAnswer.equalsIgnoreCase("no")) {
                System.out.println(userAnswer + " is wrong answer ;(. Correct answer was 'yes'");
                break;
            } else if ((!isEvenNumber) && userAnswer.equalsIgnoreCase("yes")) {
                System.out.println(userAnswer + " is wrong answer ;(. Correct answer was 'no'");
                break;
            } else {
                if (isEvenNumber) {
                    System.out.println(userAnswer + " is wrong answer ;(. Correct answer was 'yes'");
                    break;
                } else {
                    System.out.println(userAnswer + " is wrong answer ;(. Correct answer was 'no'");
                    break;
                }
            }
        }

        if (winningCount == 3) {
            System.out.println("Congratulation, " + userName + " !");
        } else {
            System.out.println("Let`s try again " + userName);
        }
    }
}
