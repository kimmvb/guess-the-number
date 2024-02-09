import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// "Superclass" abstracta. Las clases abstractas al menos tienen que tener un método abstracto.
// Además, no se pueden instanciar. Sus métodos solo pueden ser usados por sus subclases.
public abstract class Player {
    //atributo: nombre del jugador
    private final String name;
    //atributo: array tipo int de guesses (contiene todos los intentos de los jugadores)
    private final List<Integer> guesses;
    //atributo: contiene el número de ronda
    private int round;
    //atributo: contiene el último intento de los jugadores
    private int lastGuess;

    // color para la terminal
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String PURPLE = "\033[0;35m";
    public static final String BLUE = "\033[0;34m";

    //constructor de Player
    //Inicializa los atributos de la clase Player y se ubica name como argumento
    public Player(String name) {
        this.name = name;
        this.guesses = new ArrayList<>();
        this.round = 1;
        //Se inicializa con -1 porque no necesita tener un valor ahora, porque está vacía la arraylist
        this.lastGuess = -1;
    }

    //Campo estático de la clase Player. Se puede llamar desde cualquier instancia de su clase...
    //y solo existe una copia de este campo. Así: Player.numberScanner
    protected static Scanner numberScanner = new Scanner(System.in);

    protected static Scanner nameScanner = new Scanner(System.in);

    //Método getter. Trae el valor de X atributo cuando el atributo es privado y no se puede acceder...
    //directamente a él.
    public String getName() {
        return name;
    }

    public List<Integer> getGuesses() {
        return guesses;
    }

    public int getRound() {
        return round;
    }

    public int getLastGuess() {
        return lastGuess;
    }

    // Protected: Alcance de la misma clase (superclase) y sus subclases
    //Método que añade uno al atributo round. Lleva el conteo de las rondas
    protected void addRound() {
        round = round + 1;
    }

    //Método que añade un intento al arrayList guesses y ...
    //Cambia el valor de lastGuess por ese mismo intento
    protected void addGuess(int guess) {
        guesses.add(guess);
        lastGuess = guess;
    }

    //Los métodos abtractos no tienen cuerpo, ya que se espera que cada clase hija...
    // tenga diferente implementación.
    public abstract void makeGuess(int targetNumber);
}

