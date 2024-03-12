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
        System.out.println("Please enter the game number and press Enter. ");
        System.out.print(" 1. Greet \n 2. Even \n 3. Calc \n 4. GCD "
                + "\n 5. Progression \n 6. Prime \n 0. Exit \n Your choice: ");
        String gameNumber = scanner.next();
        switch (gameNumber) {
            case "1" :
                Cli.userGreeting();
                break;
            case "2" :
                Even.evenGameExecuting();
                break;
            case "3" :
                Calc.calcGameExecuting();
                break;
            case "4" :
                Gcd.gcdGameExecuting();
                break;
            case "5" :
                Progression.progressionGameExecuting();
                break;
            case "6" :
                Prime.primeGameExecuting();
                break;
            case "0" :
                System.out.println("Exit was chosen");
                break;
            default:
                System.out.print("Unknown command.");
                break;
        }
        scanner.close();
    }
}
