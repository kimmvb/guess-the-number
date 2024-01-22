import java.util.Random;

public class GuessTheNumberGame {
    //atributos: características y propiedades de la misma clase
    private Random random;
    private int targetNumber;

    //constructor: se inicia el estado de los atributos
    public GuessTheNumberGame() {
        random = new Random();
        targetNumber = random.nextInt(100);
    }
    //getter (método de acceso): Proporcionar accesso controlado a un atributo privado de una clase desde fuera de la clase
    public int getTargetNumber() {
        return targetNumber;
    }

    //método main debe: iniciar el juego y generar el número aleatorio
    public static void main(String[] args) {
        System.out.println("Welcome to Guess the number!");

        GuessTheNumberGame game = new GuessTheNumberGame();

        int guessNumber = game.getTargetNumber();

        Player.makeGuess(guessNumber);

        System.out.println(game.getTargetNumber());
    }

    public static void checkGuees(Player player) {
        player.makeGuess(guessNumber);
    }
    //método checkGuess debe: ejecutar un turno, obtener la suposición y evaluar el nuevo estado de la partida
}