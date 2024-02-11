package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the game number and press Enter. ");
        System.out.print("\n 1. Greet \n 2. Even \n 0. Exit \n Your choice: ");
        int gameNumber = scanner.nextInt();

        switch (gameNumber) {
            case 1 :
                Cli.userGreet();
                //Cli.userGreet();
                break;
            case 2 :
                String name = Cli.userGreet();
                EvenGame.evenGame(name);
                break;
            case 0 :
                System.out.println("Exit was choosen");
                break;
        }
    }
}
