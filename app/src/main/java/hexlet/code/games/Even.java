package hexlet.code.games;

import java.util.Random;

public class Even {
    public static String evenGameRules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static String[][] even() {
        Random r = new Random();
        //2d massive 3 lines 2 columns
        //first column contains game expression that will be shown to user
        //second column contains correct answer
        String[][] questionAndCorrectAnswer = new String[3][2];

        for (int i = 0; i < 3; i++) {
            //random number from 1 to 100 generating
            int randomNumber = r.nextInt(100) + 1;
            //number to string convertation
            String processedRandomNumber = Integer.toString(randomNumber);
            boolean isEvenRandomNumber = (randomNumber % 2) == 0;
            String correctAnswer = "";

            if (isEvenRandomNumber) {
                correctAnswer += "yes";
            } else {
                correctAnswer += "no";
            }

            questionAndCorrectAnswer[i][0] = processedRandomNumber;
            questionAndCorrectAnswer[i][1] = correctAnswer;
        }
        return questionAndCorrectAnswer;
    }
}
