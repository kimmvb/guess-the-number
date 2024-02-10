import java.util.Random;
public class ComputerPlayer extends Player {
    //atributo pertenicente solo a esta clase
    private final Random random;

    public ComputerPlayer(String name, Random random) {
        super(name);
        //Se añade el nuevo atributo en el constructor
        this.random = random;
    }

    //Método que revisa que tan cerca está el intento al número target.
    public void makeGuess(int targetNumber) {
        //%d = integer
        System.out.printf(BLUE +"Round %d  ➡️➡️➡️  ComputerPlayer\n" + RESET,getRound());

        //Se crea una variable qeu contiene el atributo random. Del 1 al 100.
        //+1: Se desplaza del 0 al 99 al 1 al 100
        int computerGuess = random.nextInt(100)+1;
        //%d = integer
        System.out.printf("Computer's guess: %d", computerGuess);
        //Se añade al arrayList de intentos del jugador
        addGuess(computerGuess);

        //Si el número en guessedNumber es igual al número por adivinar...
        if (computerGuess == targetNumber) {
            System.out.println(RED +"\nGame over! 😵😵😵"+ RESET);
            System.out.println(YELLOW +"Computer's attempts: ");
            System.out.println(getGuesses());
        // Pero si guessedNumber es menor que el número por adivinar...
        } else if (computerGuess < targetNumber) {
            System.out.println(RED + "\nToo low! ⬇️" + RESET);
            //Se añadé uno a la ronda
            addRound();
        // Pero si guessedNumber es mayor que el número por adivinar...
        } else {
            System.out.println(RED + "\nToo high! ⬆️" + RESET);
            //Se añadé uno a la ronda
            addRound();
        }
    }
}
//¿Más específico? (Hito 8 - Hacker Edition)
