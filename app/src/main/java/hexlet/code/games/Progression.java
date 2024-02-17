package hexlet.code.games;

import java.util.Arrays;
import java.util.Random;

public class Progression {
    private static String progressionGameRules = "What number is missing in the progression?";
    static final int STRINGSINARRAY = 3;
    static final int COLUMNSINARRAY = 2;
    static final int MAXNUMBEROFITEMS = 10;
    static final int MINNUMBEROFITEMS = 5;
    static final int MAXPROGRESSIONDEPENDENCYBORDER = 10;
    static final int MAXFIRSTNUMBERBORDER = 20;

    public static String[][] progression() {
        Random r = new Random();
        //2d massive 3 lines 2 columns
        //first column contains game expression that will be shown to user
        //second column contains correct answer
        String[][] questionAndCorrectAnswer = new String[STRINGSINARRAY][COLUMNSINARRAY];

        for (int i = 0; i < STRINGSINARRAY; i++) {
            //random number from 5 to 9 (inclusive)
            //length of resultProgression massive
            int lengthOfProgression = r.nextInt(MAXNUMBEROFITEMS - MINNUMBEROFITEMS) + MINNUMBEROFITEMS;
            int[] resultProgression = new int[lengthOfProgression];
            int progressionDependency = r.nextInt(MAXPROGRESSIONDEPENDENCYBORDER) + 1;
            //first element is inclusive, last element is exclusive
            int indexOfHidedElement = r.nextInt(lengthOfProgression);
            //first number in resultProgression (number generated from 1 to 20)
            int firstNumberOfMassive = r.nextInt(MAXFIRSTNUMBERBORDER) + 1;
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

    public static String getProgressionGameRules() {
        return progressionGameRules;
    }
}
