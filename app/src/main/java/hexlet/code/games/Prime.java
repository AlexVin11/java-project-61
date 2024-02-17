package hexlet.code.games;

import java.util.Random;

public class Prime {
    public static String primeGameRules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static String[][] prime() {
        Random r = new Random();
        //2d massive 3 lines 2 columns
        //first column contains game expression that will be shown to user
        //second column contains correct answer
        int stringsInArray = 3;
        int columnsInArray = 2;
        String[][] questionAndCorrectAnswer = new String[stringsInArray][columnsInArray];

        for (int i = 0; i < stringsInArray; i++) {
            int borderOfRandomNumber = 20;
            int numberInQuestion = r.nextInt(borderOfRandomNumber) + 1;
            String processedNumberInQuestion = Integer.toString(numberInQuestion);
            questionAndCorrectAnswer[i][0] = processedNumberInQuestion;
            boolean givenNumberIsPrime = false;
            var correctAnswer = new StringBuilder();

            for (int j = 2; j <= numberInQuestion / 2; j++) {
                if (numberInQuestion % j == 0) {
                    givenNumberIsPrime = true;
                    break;
                }
            }

            if (!givenNumberIsPrime) {
                correctAnswer = correctAnswer.append("yes");
            } else {
                correctAnswer = correctAnswer.append("no");
            }

            String processedCorrectAnswer = correctAnswer.toString();
            questionAndCorrectAnswer[i][1] = processedCorrectAnswer;
        }

        return questionAndCorrectAnswer;
    }
}
