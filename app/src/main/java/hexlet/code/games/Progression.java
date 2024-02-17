package hexlet.code.games;

import java.util.Arrays;
import java.util.Random;

public class Progression {
    public static String progressionGameRules = "What number is missing in the progression?";

    public static String[][] progression() {
        Random r = new Random();
        //2d massive 3 lines 2 columns
        //first column contains game expression that will be shown to user
        //second column contains correct answer
        int stringsInArray = 3;
        int columnsInArray = 2;
        String[][] questionAndCorrectAnswer = new String[stringsInArray][columnsInArray];

        for (int i = 0; i < stringsInArray; i++) {
            int maxNumberOfItems = 10;
            int minNumberOfItems = 5;
            int maxProgressionDependencyBorder = 10;
            int maxFirstNumberBorder = 20;
            //random number from 5 to 9 (inclusive)
            //length of resultProgression massive
            int lengthOfProgression = r.nextInt(maxNumberOfItems - minNumberOfItems) + minNumberOfItems;
            int[] resultProgression = new int[lengthOfProgression];
            int progressionDependency = r.nextInt(maxProgressionDependencyBorder) + 1;
            //first element is inclusive, last element is exclusive
            int indexOfHidedElement = r.nextInt(lengthOfProgression);
            //first number in resultProgression (number generated from 1 to 20)
            int firstNumberOfMassive = r.nextInt(maxFirstNumberBorder) + 1;
            resultProgression[0] = firstNumberOfMassive;
            String[] processedProgressionMassive = new String[lengthOfProgression];

            for (int j = 1; j < lengthOfProgression; j++) {
                resultProgression[j] = resultProgression[j - 1] + progressionDependency;
            }

            for (int k = 0; k < lengthOfProgression; k++) {
                int progressionElement = resultProgression[k];
                String processedElement = Integer.toString(progressionElement);

                if (k == indexOfHidedElement) {
                    processedProgressionMassive[k] = "..";
                } else {
                    processedProgressionMassive[k] = processedElement;
                }
            }

            String progressionMassive = Arrays.toString(processedProgressionMassive);
            String processedMassive = progressionMassive.replace("[", "");
            String progression = processedMassive.replace("]", "");
            String resultExpression = progression.replace(",", "");
            String correctAnswer = Integer.toString(resultProgression[indexOfHidedElement]);
            questionAndCorrectAnswer[i][0] = resultExpression;
            questionAndCorrectAnswer[i][1] = correctAnswer;
        }

        return questionAndCorrectAnswer;
    }
}
