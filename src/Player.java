import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public abstract class Player {
    private String name;
    //atributo - array tipo int de guesses
    private List<Integer> guesses;
    private int round;
    private  int lastGuess;

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
    protected void setName(String playerName) {
        name = playerName;
    }

    public List<Integer> getGuesses() {
        return guesses;
    }

    public void addGuess(int guess) {
        guesses.add(guess);
        lastGuess = guess;
    }

    public int getLastGuess() {
        return lastGuess;
    }

    public void addRound() {
        round = round + 1;
    }

    public int getRound() {
        return round;
    }

    protected static Scanner nameScanner = new Scanner(System.in);
    public abstract void makeGuess(int targetNumber);
}

