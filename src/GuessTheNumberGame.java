import java.util.Random;

public class GuessTheNumberGame {
    //atributos: características y propiedades de la misma clase
    private Random random;
    private int targetNumber;

    //constructor: se inicia el estado de los atributos
    public GuessTheNumberGame() {
        random = new Random();
        targetNumber = random.nextInt(100)+1;
    }
    //getter (método de acceso): Proporcionar accesso controlado a un atributo privado de una clase desde fuera de la clase
    public int getTargetNumber() {
        return targetNumber;
    }

    //método main debe: iniciar el juego y generar el número aleatorio
    public static void main(String[] args) {
        System.out.println("Welcome to Guess the number!");
        System.out.print("Enter your name: ");

        GuessTheNumberGame game = new GuessTheNumberGame();

        String playerName = Player.nameScanner.nextLine();
        Player humanPlayer = new HumanPlayer(playerName);

        boolean correctGuess = false;

        while (!correctGuess) {
            checkGuees(humanPlayer, game.getTargetNumber());
            if(humanPlayer.getLastGuess() == game.getTargetNumber()) {
                correctGuess = true;
            }
        }
    }

    public static void checkGuees(Player player, int targetNumber) {

        System.out.println(targetNumber);

        player.makeGuess(targetNumber);
    }
    //método checkGuess debe: ejecutar un turno, obtener la suposición y evaluar el nuevo estado de la partida
}
//Caso 1: Persona pone una letra u otro símbolo en vez de un número
//Caso 2: Persona escribe un número superior a 100 o menor a 0
//Caso 3: Persona no coloca su nombre
