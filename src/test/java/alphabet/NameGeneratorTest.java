package alphabet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NameGeneratorTest {

    @Test
    void shouldReturnStringWithName() {
        // given

        // when
        var result = NameGenerator.generateOneName();

        //then
        assertAll(
                () -> assertFalse(result.isEmpty()),
                () -> assertFalse(result.isBlank())
        );
    }
}
