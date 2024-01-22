import java.util.Scanner;
public abstract class Player {
    private String name;
    //atributo - array tipo int de guesses
    private int[] guesses;

    public String getName() {
        return name;
    }

    public int[] getGuesses() {
        return guesses;
    }

    protected static Scanner numberScanner = new Scanner(System.in);

    public abstract void makeGuess(int targetNumber);

}

