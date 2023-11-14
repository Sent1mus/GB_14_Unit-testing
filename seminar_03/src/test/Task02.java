import main.Main;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

public class Task02 {
    @ParameterizedTest
    @ValueSource (ints = {26, 50, 75, 99})
    void numberInInterval (int i) {
        assertThat(Main.numberInInterval(i)).isTrue();
    }
}
