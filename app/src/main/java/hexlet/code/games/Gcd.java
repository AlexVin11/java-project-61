package hexlet.code.games;


import java.util.Random;

public class Gcd {
    public static String gcdGameRules = "Find the greatest common divisor of given numbers.";
    public static String[][] gcd() {
        Random r = new Random();
        //2d massive 3 lines 2 columns
        //first column contains game expression that will be shown to user
        //second column contains correct answer
        String[][] questionAndCorrectAnswer = new String[3][2];

        for (int i = 0; i < 3; i++) {
            //random numbers from 1 to 50 generated and converted to String
            int firstNumber = r.nextInt(20) + 1;
            int secondNumber = r.nextInt(20) + 1;
            String processedFirstNumber = Integer.toString(firstNumber);
            String processedSecondNumber = Integer.toString(secondNumber);
            var expressionForCalculate = new StringBuilder();
            expressionForCalculate.append(processedFirstNumber);
            expressionForCalculate.append(" ");
            expressionForCalculate.append(processedSecondNumber);
            //final expression
            String expression = expressionForCalculate.toString();
            questionAndCorrectAnswer[i][0] = expression;

            for (int j = 1; j <= firstNumber && j <= secondNumber; j++) {
                if (firstNumber % j == 0 && secondNumber % j == 0) {
                    questionAndCorrectAnswer[i][1] = Integer.toString(j);
                }
            }
            continue;
        }
        return questionAndCorrectAnswer;
    }
}