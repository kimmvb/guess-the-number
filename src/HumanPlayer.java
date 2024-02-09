public class HumanPlayer extends Player {

    //Se usa la palabra clase super() para inicializar correctamente el argumento con el mismo nombre.
    //Este argumento es parte del cosntructor Player por esto se tiene que inicializar.
    public HumanPlayer(String name) {
        super(name);
    }

    //Método que revisa que el input del usuario sea válido
    private int validNumber() {
        //%d = integer; %s = String
        System.out.printf(PURPLE + "Round %d  ➡️➡️➡️  %s\n" + RESET, getRound(), getName());
        //Variable donde se almacenará el valor del intento del jugador
        int guessedNumber;
        //Mientras sea verdadero, siempre se repitirá el bucle hasta que llegue un número válido
        while (true) {
            System.out.print("Enter your guess (between 1 and 100): ");
            //Si el intento es un número...
            if (numberScanner.hasNextInt()) {
                //Se le dará ese valor a la variable guessedNumber
                guessedNumber = numberScanner.nextInt();
                //Si la variable está entre 1 y 100, se romperá el bucle
                if (guessedNumber >= 1 && guessedNumber <= 100) {
                    break;
                } else {
                    //En el caso de que no esté entre este rango, se enviará un mensaje en consola
                    System.out.println(RED + "Please enter a number between 1 and 100 ❌"+ RESET);
                }
            } else {
                //Si el intento no sea un número, se enviará un mensaje a consola
                System.out.println(RED +"Please enter a valid integer ❌"+ RESET);
                numberScanner.next(); // Consumir la entrada no válida para evitar un bucle infinito
            }
        }
        //Cuando se salga del bucle se añadirá al arrayList de intentos del jugador y...
        addGuess(guessedNumber);
        //Se retornará dicho valor
        return guessedNumber;
    }

    //Método que revisa que tan cerca está el intento validado al número target.
    public void makeGuess(int targetNumber) {
        //Le entrega el valor de retorno del método validNumber() a la variable guessedNumber
        int guessedNumber = validNumber();

        //Si el número en guessedNumber es igual al número por adivinar...
        if (guessedNumber == targetNumber) {
            System.out.println(GREEN + "You won! Congratulations! 🎉🎉🎉" + RESET);
            System.out.println(YELLOW + "Your attempts: ");
            //Imprimir el arrayList
            System.out.println(getGuesses());
        // Pero si guessedNumber es menor que el número por adivinar...
        } else if (guessedNumber < targetNumber) {
            System.out.println(RED + "Too low! ⬇️" + RESET);
            //Se añadé uno a la ronda
            addRound();
        // Pero si guessedNumber es mayor que el número por adivinar...
        } else {
            System.out.println(RED + "Too high! ⬆️" + RESET);
            //Se añadé uno a la ronda
            addRound();
        }
    }
}
