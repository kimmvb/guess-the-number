import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class HumanPlayerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void shouldPrintTooLow_HumanPlayer() {
        // Configurar la entrada simulada
        String input = "20\n"; // Simula la entrada del usuario: "20" seguido de un salto de línea
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        // Redirigir System.out a outContent (salida)
        System.setOut(new PrintStream(outContent));

        // Crear una instancia de HumanPlayer
        HumanPlayer player = new HumanPlayer("TestPlayer");

        // Definir el número objetivo
        int targetNumber = 50;

        // Llamar al método makeGuess()
        player.makeGuess(targetNumber);

        // Verificar la salida esperada
        String output = outContent.toString().trim();

        //La salida de la terminal contiene:
        assertTrue(output.contains("Too low! ⬇️"));
        assertFalse(output.contains("Too high! ⬆️"));
        //Se espera que dentro del objeto player haya:
        //AsserEquals chequea valores de retorno
        assertEquals(1, player.getGuesses().size());
        assertEquals(20, player.getGuesses().getFirst());
    }
}
