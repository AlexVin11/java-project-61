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

    public static int[] progressionGenerating(int firstElement, int progressionDependency, int progressionLength) {
        int[] progression = new int[progressionLength];
        progression[0] = firstElement;
        for (int i = 1; i < progressionLength; i++) {
            progression[i] = progression[i - 1] + progressionDependency;
        }
        return progression;
    }

    public static String[][] progressionArrayCreating() {
        String[][] expressionAndCorrectAnswer = new String[STRINGSINGENERATEDARRAY][COLUMNSINGENERATEDARRAY];
        int lengthOfProgression = Utils.generateRandomInt(MINNUMBEROFITEMS, MAXNUMBEROFITEMS);
        int progressionDependency = Utils.generateRandomInt(MINPROGRESSIONDEPENDENCY, MAXPROGRESSIONDEPENDENCY);
        int indexOfHidedElement = Utils.generateRandomInt(lengthOfProgression);
        int firstNumberOfMassive = Utils.generateRandomInt(MINFIRSTNUMBERBORDER, MAXFIRSTNUMBERBORDER);
        int[] progression = progressionGenerating(firstNumberOfMassive, progressionDependency, lengthOfProgression);
        String correctAnswer = Integer.toString(progression[indexOfHidedElement]);
        expressionAndCorrectAnswer[0][1] = correctAnswer;
        String progressionAsString = Arrays.toString(progression).replaceAll("[\\[\\]]", "");
        var progressionElements = progressionAsString.split(", ");
        progressionElements[indexOfHidedElement] = "..";
        expressionAndCorrectAnswer[0][0] = String.join(" ", progressionElements);
        return expressionAndCorrectAnswer;
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
