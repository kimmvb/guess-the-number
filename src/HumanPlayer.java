import java.util.Scanner;
public class HumanPlayer extends Player {
    public void makeGuess(int targetNumber) {
        System.out.print("Enter your guess: ");
        int guessedNumber = numberScanner.nextInt();

        if (guessedNumber == targetNumber) {
            System.out.println("You win! Congratulations!");
        } else if (guessedNumber < targetNumber) {
            System.out.println("Too low!");
        } else {
            System.out.println("Too high!");
        }
    }
}
