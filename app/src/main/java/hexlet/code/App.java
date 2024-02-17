package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //gaming rules taken from the static variables in games
        String evenGameRules = Even.evenGameRules;
        String calcGameRules = Calc.calcGameRules;
        String gcdGameRules = Gcd.gcdGameRules;
        String progressionGameRules = Progression.progressionGameRules;
        String primeGameRules = Prime.primeGameRules;
        System.out.println("Please enter the game number and press Enter. ");
        System.out.print(" 1. Greet \n 2. Even \n 3. Calc \n 4. GCD "
                + "\n 5. Progression \n 6. Prime \n 0. Exit \n Your choice: ");
        int gameNumber = scanner.nextInt();

        switch (gameNumber) {
            case 1 :
                Cli.userGreet();
                break;
            case 2 :
                String[][] argumentsEvenGames = Even.even();
                Engine.engine(argumentsEvenGames, evenGameRules);
                break;
            case 3 :
                String[][] argumentsCalcGames = Calc.calc();
                Engine.engine(argumentsCalcGames, calcGameRules);
                break;
            case 4 :
                String[][] argumentsGcdGame = Gcd.gcd();
                Engine.engine(argumentsGcdGame, gcdGameRules);
                break;
            case 5 :
                String[][] argumentsProgressionGame = Progression.progression();
                Engine.engine(argumentsProgressionGame, progressionGameRules);
                break;
            case 6 :
                String[][] argumentsPrimeGame = Prime.prime();
                Engine.engine(argumentsPrimeGame, primeGameRules);
                break;
            case 0 :
                Cli.userGreet();
                break;
                /*System.out.println("Exit was chosen");
                break;*/
            default:
                System.out.print("Unknown command.");
                break;
        }
    }
}
