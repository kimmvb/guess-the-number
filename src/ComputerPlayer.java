import java.util.Random;
public class ComputerPlayer extends Player {
    public ComputerPlayer(String name) {
        super(name);
    }

    public void makeGuess(int targetNumber) {
        System.out.printf(BLUE +"Round %d  ➡️➡️➡️  ComputerPlayer\n" + RESET,getRound());

        Random random = new Random();
        int computerGuess = random.nextInt(100)+1;
        System.out.printf("Computer's guess: %d", computerGuess);
        addGuess(computerGuess);

        if (computerGuess == targetNumber) {
            System.out.println(RED +"\nGame over! 😵😵😵"+ RESET);
            System.out.println(YELLOW +"Computer's attempts: ");
            System.out.println(getGuesses());
        } else if (computerGuess < targetNumber) {
            System.out.println(RED + "\nToo low! ⬇️" + RESET);
            addRound();
        } else {
            System.out.println(RED + "\nToo high! ⬆️" + RESET);
            addRound();
        }
    }
}
//¿Más específico? (Hito 8 - Hacker Edition)
