import main.Main;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class Task01 {
    @ParameterizedTest
    @ValueSource(ints = {-2, 0, 2, 4, 10, 100, 1000000000})
    void evenNumber(int i) {
        assertTrue(Main.evenOddNumber(i));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 1, 3, 13, 53})
    void notEvenNumber(int i) {
        assertFalse(Main.evenOddNumber(i));
    }

}