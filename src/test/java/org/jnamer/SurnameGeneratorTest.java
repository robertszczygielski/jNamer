package org.jnamer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.jnamer.BasicSurnames.SURNAMES;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SurnameGeneratorTest {

    @Test
    void shouldReturnStringWithOneRandomSurname() {
        // given

        // when
        var result = Surname.generateOne();

        // then
        assertTrue(SURNAMES.contains(result));
    }

    @DisplayName("Return list of surnames")
    @ParameterizedTest(name = "that contains {0} elements")
    @CsvSource({"1", "2", "7"})
    void shouldReturnStringWithOneRandomSurname(int numberOfSurnames) {
        // given

        // when
        var result = Surname.numberOfNames(numberOfSurnames).generate();

        // then
        assertTrue(SURNAMES.containsAll(result));
    }
}
