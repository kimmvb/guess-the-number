import java.util.Random;

public class GuessTheNumberGame {
    private final int targetNumber;

    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String WHITE_UNDERLINED = "\033[4;37m";

    //constructor: se inicia el estado de los atributos
    public GuessTheNumberGame() {
        //atributos: características y propiedades de la misma clase
        Random random = new Random();
        targetNumber = random.nextInt(100) + 1;
    }

    //getter (método de acceso): Proporcionar accesso controlado a un atributo privado de una clase desde fuera de la clase
    public int getTargetNumber() {
        return targetNumber;
    }

    //método main debe: iniciar el juego y generar el número aleatorio
    public static void main(String[] args) {
        System.out.println(WHITE_UNDERLINED +"👾👾👾 Welcome to Guess the Number 👾👾👾"+ RESET);

        String playerName = "";
        while (playerName.isEmpty()) {
            System.out.print("Enter your name: ");
            playerName = Player.nameScanner.nextLine().trim();
            if (playerName.isEmpty()) {
                System.out.println(RED +"Please enter a non-empty name ❌"+ RESET);
            }
        }

        GuessTheNumberGame game = new GuessTheNumberGame();

        Player humanPlayer = new HumanPlayer(playerName);
        String computerName = "Computer Player";
        Player computerPlayer = new ComputerPlayer(computerName);

        while (true) {
            checkGuees(humanPlayer, game.getTargetNumber());
            if (humanPlayer.getLastGuess() == game.getTargetNumber()) {
                break;
            }

            checkGuees(computerPlayer, game.getTargetNumber());
            if (computerPlayer.getLastGuess() == game.getTargetNumber()) {
                break;
            }
        }
    }

    public static void checkGuees(Player player, int targetNumber) {

        System.out.println(targetNumber);

        player.makeGuess(targetNumber);
    }
    //método checkGuess debe: ejecutar un turno, obtener la suposición y evaluar el nuevo estado de la partida
}

