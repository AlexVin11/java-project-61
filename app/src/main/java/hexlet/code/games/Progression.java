package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;

public class Progression {
    private static final String PROGRESSIONGAMERULES = "What number is missing in the progression?";
    static final int MAXNUMBEROFITEMS = 10;
    static final int MINNUMBEROFITEMS = 5;
    static final int MAXPROGRESSIONDEPENDENCY = 10;
    static final int MINPROGRESSIONDEPENDENCY = 5;
    static final int MAXFIRSTNUMBERBORDER = 20;
    static final int MINFIRSTNUMBERBORDER = 5;
    static final int STRINGSINGENERATEDARRAY = 1;
    static final int COLUMNSINGENERATEDARRAY = 2;

    public static String[][] generatingCorrectProgressionAnswer(int[] progression, int indexOfHidedElement) {
        String[][] expressionAndCorrectAnswer = new String[STRINGSINGENERATEDARRAY][COLUMNSINGENERATEDARRAY];
        String progressionAsString = Arrays.toString(progression).replaceAll("[\\[\\]]", "");
        String correctAnswer = Integer.toString(progression[indexOfHidedElement]);
        expressionAndCorrectAnswer[0][1] = correctAnswer;
        //array of String created
        var progressionElements = progressionAsString.split(", ");
        progressionElements[indexOfHidedElement] = "..";
        expressionAndCorrectAnswer[0][0] = String.join(" ", progressionElements);

        return expressionAndCorrectAnswer;
    }

    public static String[][] progressionArrayCreating() {
        //2d massive 1 lines 2 columns
        //first column contains game expression that will be shown to user
        //second column contains correct answer
        String[][] expressionAndCorrectAnswer = new String[STRINGSINGENERATEDARRAY][COLUMNSINGENERATEDARRAY];
        int lengthOfProgression = Utils.generateRandomInt(MINNUMBEROFITEMS, MAXNUMBEROFITEMS);
        int[] progression = new int[lengthOfProgression];
        int progressionDependency = Utils.generateRandomInt(MINPROGRESSIONDEPENDENCY, MAXPROGRESSIONDEPENDENCY);
        int indexOfHidedElement = Utils.generateRandomInt(lengthOfProgression);
        //first number in resultProgression (number generated from 1 to 20)
        int firstNumberOfMassive = Utils.generateRandomInt(MINFIRSTNUMBERBORDER, MAXFIRSTNUMBERBORDER);
        progression[0] = firstNumberOfMassive;

        for (int j = 1; j < lengthOfProgression; j++) {
            progression[j] = progression[j - 1] + progressionDependency;
        }

        String[][] resultArray = generatingCorrectProgressionAnswer(progression, indexOfHidedElement);

        return resultArray;
    }

    public static void progressionGameExecuting() {
        String[][] questionAndCorrectAnswer = new String[Engine.GAMESTOWIN][COLUMNSINGENERATEDARRAY];

        for (int i = 0; i < Engine.GAMESTOWIN; i++) {
            String[][] processedArray = progressionArrayCreating();
            questionAndCorrectAnswer[i][0] = processedArray[0][0];
            questionAndCorrectAnswer[i][1] = processedArray[0][1];
        }

        Engine.engine(questionAndCorrectAnswer, PROGRESSIONGAMERULES);
    }
}
