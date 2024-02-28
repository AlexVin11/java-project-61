package hexlet.code.games;

import hexlet.code.Engine;

public class Calc1 {
    private static final String CALCGAMERULES = "What is the result of the expression?";
    static final int BORDEROFNUMBER = 50;
    static final int STRINGSINGENERATEDARRAY = 1;
    static final int COLUMNSINGENERATEDARRAY = 2;
    static final char[] OPERATORS = {'+', '-', '*'};

    public static int generatingCorrectCalcExpression(int firstNumber, int secondNumber, char operator) {
        int resultOfExpression = 0;

        if (operator == '+') {
            resultOfExpression = firstNumber + secondNumber;
        } else if (operator == '-') {
            resultOfExpression = firstNumber - secondNumber;
        } else if (operator == '*') {
            resultOfExpression = firstNumber * secondNumber;
        }

        return resultOfExpression;
    }

    public static String[][] calcArrayCreating1() {
        //2d massive: 1 line and 2 columns
        //first column contains game expression that will be shown to user
        //second column contains correct answer
        String[][] questionAndCorrectAnswer = new String[STRINGSINGENERATEDARRAY][COLUMNSINGENERATEDARRAY];
        int i = 0;

        while (i < STRINGSINGENERATEDARRAY) {
            var firstNumber = Utils.generateRandomInt(BORDEROFNUMBER) + 1;
            var secondNumber = Utils.generateRandomInt(BORDEROFNUMBER) + 1;
            var charIndexGenerator = Utils.generateRandomInt(OPERATORS.length);
            String processedFirstNumber = Integer.toString(firstNumber);
            String processedSecondNumber = Integer.toString(secondNumber);
            var expressionForCalculate = new StringBuilder();
            expressionForCalculate.append(processedFirstNumber);
            expressionForCalculate.append(" ");
            expressionForCalculate.append(Character.toString(OPERATORS[charIndexGenerator]));
            expressionForCalculate.append(" ");
            expressionForCalculate.append(processedSecondNumber);
            //Final expression
            String expression = expressionForCalculate.toString();
            String correctAnswer = String.valueOf(generatingCorrectCalcExpression(firstNumber, secondNumber, OPERATORS[charIndexGenerator]));

            questionAndCorrectAnswer[i][0] = expression;
            questionAndCorrectAnswer[i][1] = correctAnswer;
            i++;
        }

        return questionAndCorrectAnswer;
    }

    public static void calcGameExecuting1() {
        String[][] questionAndCorrectAnswer = new String[Engine.GAMESTOWIN][COLUMNSINGENERATEDARRAY];
        int i = 0;

        while (i < Engine.GAMESTOWIN) {
            String[][] processedArray = calcArrayCreating1();
            questionAndCorrectAnswer[i][0] = processedArray[0][0];
            questionAndCorrectAnswer[i][1] = processedArray[0][1];
            i++;
        }

        Engine.engine(questionAndCorrectAnswer, CALCGAMERULES);
    }
}
