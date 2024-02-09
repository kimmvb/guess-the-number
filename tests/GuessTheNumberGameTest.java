import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GuessTheNumberGameTest {

    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private final String lineSeparator = System.lineSeparator();

    @BeforeEach
    public void setUp() {
        // Redirigir la entrada del sistema a un nuevo InputStream
        System.setIn(new ByteArrayInputStream((
                "Player 1" + lineSeparator
        ).getBytes()));
    }

    @AfterEach
    public void tearDown() {
        // Restaurar la entrada del sistema al valor original
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    @Test
    public void findPlayersNameCorrectly() {

        String result = GuessTheNumberGame.findPlayerName();

        assertEquals("Player 1", result);
    }

    @Test
    public void takeTurnsCorrectly_HumanPlayerWins() {
        //Creación de mock de clase Player
        Player humanPlayerMock = Mockito.mock(Player.class);
        Player computerPlayerMock = Mockito.mock(Player.class);

        int targetNumber = 50;

        //Cuando se pida el valor del método getLasGuess se retornará el valor de targetNumber
        //when: Se usa con un mock
        Mockito.when(humanPlayerMock.getLastGuess()).thenReturn(targetNumber);

        //Se llama al método de takeTurns con los valores mock como argumento
        GuessTheNumberGame.takeTurns(humanPlayerMock, computerPlayerMock, targetNumber);

        //Se verifica que se no se llamó a makeGuess del lado del computerPlayer
        Mockito.verify(computerPlayerMock, Mockito.never()).makeGuess(Mockito.anyInt());
        //Se verifica que se llamó a makeGuess una vez del lado del humanPlayer
        Mockito.verify(humanPlayerMock, Mockito.times(1)).makeGuess(Mockito.anyInt());
    }

    @Test
    public void takeTurnsCorrectly_ComputerPlayerWins() {
        Player humanPlayerMock = Mockito.mock(Player.class);
        Player computerPlayerMock = Mockito.mock(Player.class);
        int targetNumber = 50;

        Mockito.when(humanPlayerMock.getLastGuess()).thenReturn(58);
        Mockito.when(computerPlayerMock.getLastGuess()).thenReturn(targetNumber);

        GuessTheNumberGame.takeTurns(humanPlayerMock, computerPlayerMock, targetNumber);

        Mockito.verify(humanPlayerMock, Mockito.times(1)).makeGuess(Mockito.anyInt());
        Mockito.verify(computerPlayerMock, Mockito.times(1)).makeGuess(Mockito.anyInt());
    }
}

//Quizás podría agregarse orden de ejecución para ayudar con los errores