import java.util.Scanner;
public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    public void makeGuess(int targetNumber) {
        System.out.printf("Round %d  -  %s\n" ,getRound(), getName());

        System.out.print("Enter your guess: ");
        int guessedNumber = numberScanner.nextInt();
        addGuess(guessedNumber);

        if (guessedNumber == targetNumber) {
            System.out.println("You won! Congratulations! 🎉🎉🎉");
            System.out.println("Your attempts: ");
            System.out.println(getGuesses());
        } else if (guessedNumber < targetNumber) {
            System.out.println("Too low!");
            addRound();
        } else {
            System.out.println("Too high!");
            addRound();
        }
    }
}
