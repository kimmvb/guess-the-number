public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    public void makeGuess(int targetNumber) {
        System.out.printf(PURPLE + "Round %d  ➡️➡️➡️  %s\n" + RESET, getRound(), getName());

        int guessedNumber;

        while (true) {
            System.out.print("Enter your guess (between 1 and 100): ");
            if (numberScanner.hasNextInt()) {
                guessedNumber = numberScanner.nextInt();
                if (guessedNumber >= 1 && guessedNumber <= 100) {
                    break;
                } else {
                    System.out.println(RED + "Please enter a number between 1 and 100 ❌"+ RESET);
                }
            } else {
                System.out.println(RED +"Please enter a valid integer ❌"+ RESET);
                numberScanner.next(); // Consumir la entrada no válida para evitar un bucle infinito
            }
        }

        addGuess(guessedNumber);

        if (guessedNumber == targetNumber) {
            System.out.println(GREEN + "You won! Congratulations! 🎉🎉🎉" + RESET);
            System.out.println(YELLOW + "Your attempts: ");
            System.out.println(getGuesses());
        } else if (guessedNumber < targetNumber) {
            System.out.println(RED + "Too low! ⬇️" + RESET);
            addRound();
        } else {
            System.out.println(RED + "Too high! ⬆️" + RESET);
            addRound();
        }
    }
}
