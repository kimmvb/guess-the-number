import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.ArgumentMatchers;

class ComputerPlayerTest {
    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldPrintTooLow_ComputerPlayer() {
        //Se crea un mock de la clase Random
        Random mockRandom = Mockito.mock(Random.class);

        //Se crea una nueva instancia de la clase computerplayer
        //Uno de sus argumentos es el mock
        ComputerPlayer player = new ComputerPlayer("Computer", mockRandom);

        //Cuando el mockRandom use el método nextInt, se retornará 19
        //Se espera que el valor sea de nextInt(int bound), por eso se usa ArgumentMatchers.anyInt()
        Mockito.when(mockRandom.nextInt(ArgumentMatchers.anyInt())).thenReturn(19);

        int targetNumber = 50;

        //Se ejecuta el método makeGuess
        player.makeGuess(targetNumber);

        String output = outContent.toString().trim();
        //La salida de la terminal contiene:
        assertTrue(output.contains("Too low! ⬇️"));
        assertFalse(output.contains("Too high! ⬆️"));
    }

    @Test
    public void shouldPrintTooHigh_ComputerPlayer() {

        Random mockRandom = Mockito.mock(Random.class);

        ComputerPlayer player = new ComputerPlayer("Computer", mockRandom);

        Mockito.when(mockRandom.nextInt(ArgumentMatchers.anyInt())).thenReturn(79);

        int targetNumber = 50;

        player.makeGuess(targetNumber);

        String output = outContent.toString().trim();
        assertFalse(output.contains("Too low! ⬇️"));
        assertTrue(output.contains("Too high! ⬆️"));
    }

    @Test
    public void shouldPrintGameOver_ComputerPlayer() {

        Random mockRandom = Mockito.mock(Random.class);

        ComputerPlayer player = new ComputerPlayer("Computer", mockRandom);

        Mockito.when(mockRandom.nextInt(ArgumentMatchers.anyInt())).thenReturn(49);

        int targetNumber = 50;

        player.makeGuess(targetNumber);

        String output = outContent.toString().trim();

        assertTrue(output.contains("Game over! 😵😵😵"));
    }
}