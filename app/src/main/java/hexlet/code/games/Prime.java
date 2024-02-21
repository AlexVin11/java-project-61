package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Prime {
    private static String primeGameRules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    static final int STRINGSINARRAY = 3;
    static final int COLUMNSINARRAY = 2;
    static final int BORDEROFRANDOMNUMBER = 20;

    public static void prime() {
        Random r = new Random();
        //2d massive 3 lines 2 columns
        //first column contains game expression that will be shown to user
        //second column contains correct answer
        String[][] questionAndCorrectAnswer = new String[STRINGSINARRAY][COLUMNSINARRAY];

        for (int i = 0; i < STRINGSINARRAY; i++) {
            int numberInQuestion = r.nextInt(BORDEROFRANDOMNUMBER) + 2;
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

        Engine.engine(questionAndCorrectAnswer, primeGameRules);
    }
}
