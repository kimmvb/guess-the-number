import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public abstract class Player {
    private final String name;
    //atributo - array tipo int de guesses
    private final List<Integer> guesses;
    private int round;
    private  int lastGuess;

    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String PURPLE = "\033[0;35m";
    public static final String BLUE = "\033[0;34m";
    public Player(String name) {
        this.name = name;
        this.guesses = new ArrayList<>();
        this.round =  1;
        this.lastGuess = -1;
    }

    protected static Scanner numberScanner = new Scanner(System.in);

    public String getName() {
        return name;
    }

    protected static Scanner nameScanner = new Scanner(System.in);

    public List<Integer> getGuesses() {
        return guesses;
    }

    public void addRound() {
        round = round + 1;
    }

    public int getRound() {
        return round;
    }
    public void addGuess(int guess) {
        guesses.add(guess);
        lastGuess = guess;
    }

    public int getLastGuess() {
        return lastGuess;
    }

    public abstract void makeGuess(int targetNumber);
}

