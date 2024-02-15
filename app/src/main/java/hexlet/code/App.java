package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.EvenGame;
import hexlet.code.games.Gcd;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //gaming rules taken from the static variables in games
        String evenGameRules = EvenGame.evenGameRules;
        String calcGameRules = Calc.calcGameRules;
        String gcdGameRules = Gcd.gcdGameRules;
        System.out.println("Please enter the game number and press Enter. ");
        System.out.print(" 1. Greet \n 2. Even \n 3. Calc \n 4. GCD \n 0. Exit \n Your choice: ");
        int gameNumber = scanner.nextInt();

        switch (gameNumber) {
            case 1 :
                Cli.userGreet();
                break;
            case 2 :
                String[][] argumentsEvenGames = EvenGame.evenGame();
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
            case 0 :
                System.out.println("Exit was chosen");
                break;
            default:
                System.out.print("Unknown command.");
                break;
        }
    }
}
