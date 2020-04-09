package org.jnamer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.jnamer.BasicNames.FEMALE_NAMES;
import static org.jnamer.BasicNames.MALE_NAMES;
import static org.junit.jupiter.api.Assertions.*;

class FemaleNameGeneratorTest {

    @Test
    void shouldReturnOneFemaleName() {
        // given
        // when
        var result = FemaleName.generateOne();

        // then
        assertTrue(FEMALE_NAMES.contains(result));
    }

    @Test
    void shouldReturnOneFemaleNameWithSurname() {
        // given
        // when
        var result = FemaleName.withSurname().generate();

        // then
        var splitResult = result.split("\\s");
        assertAll(
                () -> assertTrue(FEMALE_NAMES.contains(splitResult[0])),
                () -> assertTrue(BasicSurnames.SURNAMES.contains(splitResult[1]))
        );
    }

    @Test
    void shouldReturnOneMsFemaleName() {
        // given
        // when
        var result = FemaleName.withMs().generate();

        // then
        var splitResult = result.split("\\s");
        assertAll(
                () -> assertEquals(splitResult[0], Gender.MS.getSignOfRespect()),
                () -> assertTrue(FEMALE_NAMES.contains(splitResult[1]))
        );
    }

    @DisplayName("Return list of female names")
    @ParameterizedTest(name = "that contains {0} elements")
    @CsvSource({"1", "2", "7"})
    void shouldReturnListWithFemaleNames(int numberOfNames) {
        // given

        // when
        var result = FemaleName.numberOfNames(numberOfNames).generate();

        // then
        assertAll(
                () -> assertEquals(numberOfNames, result.size()),
                () -> assertTrue(FEMALE_NAMES.containsAll(result)),
                () -> assertFalse(MALE_NAMES.containsAll(result))
        );
    }

}
