package org.jnamer;

import org.junit.jupiter.api.Test;

import static org.jnamer.SurnameGenerator.SURNAMES;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SurnameGeneratorTest {

    @Test
    void shouldReturnStringWithOneRandomSurname() {
        // given

        // when
        var result = SurnameGenerator.generateOne();

        // then
        assertTrue(SURNAMES.contains(result));
    }
}
