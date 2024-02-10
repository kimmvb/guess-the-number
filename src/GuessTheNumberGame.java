import java.util.Random;

public class GuessTheNumberGame {
    //Los atributos son características y propiedades de la misma clase
    //Atributo: clase random para contener el número random
    public final Random random;
    //Atributo privado: contiene el número target, solo se puede usar en la misma clase donde...
    //es creado
    private final int targetNumber;

    // color para la terminal
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String WHITE_UNDERLINED = "\033[4;37m";

    //constructor: Se inicia el estado de los atributos
    public GuessTheNumberGame() {
        //Creación de nuevo número Random
        random = new Random();
        //Se guarda en el atributo targetNumber un número random entre 1 y 100
        targetNumber = random.nextInt(100) + 1;
    }

    //getter (método de acceso): Proporcionar accesso controlado a un atributo privado...
    // de una clase desde fuera de la clase
    public int getTargetNumber() {
        return targetNumber;
    }

    //método main debe: iniciar el juego y generar el número aleatorio
    public static void main(String[] args) {
        System.out.println(WHITE_UNDERLINED +"👾👾👾 Welcome to Guess the Number 👾👾👾"+ RESET);

        //Se crea una nueva instancia de GuessTheNumberGame
        GuessTheNumberGame game = new GuessTheNumberGame();

        //Se crea una nueva instancia de Player(HumanPlayer)
        //Para obtener el valor del argumento name, se llama al método findPlayerName()
        Player humanPlayer = new HumanPlayer(findPlayerName());

        //Variable con un nombre default a la nueva instancia de Computer Player
        String computerName = "Computer Player";
        //Se crea una nueva instancia de Player(ComputerPlayer)
        //Para el segundo argumento se llama a la variable random de game
        Player computerPlayer = new ComputerPlayer(computerName, game.random);

        //Se llama al método takeTurns
        takeTurns(humanPlayer,computerPlayer, game.getTargetNumber());
    }

    //Método que entrega un nombre de usuario válido
    public static String findPlayerName() {
        //Se crea una variable para guardar el nombre del jugador y se la inicializa.
        String playerName = "";
        //Mientras la variable playerName este vacía...
        while (playerName.isEmpty()) {
            System.out.print("Enter your name: ");
            //Se le dará el valor de campo estático nameScanner y se usará trim para eliminar cualquier espacio en blanco
            playerName = Player.nameScanner.nextLine().trim();
            //Si a variable playerName este vacía...
            if (playerName.isEmpty()) {
                //Se imprimirá un mensaje en la terminal
                System.out.println(RED +"Please enter a non-empty name ❌"+ RESET);
            }
        }
        //Cuando se rompa el bucle, se retornará la variable playerName
        return playerName;
    }

    //Método que chequea el intento del jugador
    public static void checkGuees(Player player, int targetNumber) {

        //System.out.println(targetNumber);

        player.makeGuess(targetNumber);
    }

    //Método que ejecuta los turnos de los jugadores hasta que se rompa el bucle
    public static void takeTurns(Player humanPlayer, Player computerPlayer, int targetNumber) {
        //Mientras sea verdadero...
        while (true) {
            //Se chequea la respuesta del humanPlayer
            checkGuees(humanPlayer, targetNumber);
            //Si el último intento del humanPlayer es igual al número por adivinar, se romperá el bucle
            if (humanPlayer.getLastGuess() == targetNumber) {
                break;
            }

            //Se chequea la respuesta del computerPlayer
            checkGuees(computerPlayer, targetNumber);
            //Si el último intento del computerPlayer es igual al número por adivinar, se romperá el bucle
            if (computerPlayer.getLastGuess() == targetNumber) {
                break;
            }
        }
    }
}

