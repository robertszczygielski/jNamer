package org.jnamer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.jnamer.BasicNames.FEMALE_NAMES;
import static org.jnamer.BasicNames.MALE_NAMES;
import static org.junit.jupiter.api.Assertions.*;

class MaleNameGeneratorTest {

    @Test
    void shouldReturnOneMaleName() {
        // given
        // when
        var result = MaleName.generateOne();

        // then
        assertTrue(MALE_NAMES.contains(result));
    }

    @Test
    void shouldReturnOneMaleNameWithSurname() {
        // given
        // when
        var result = MaleName.withSurname().generate();

        // then
        var splitResult = result.split("\\s");
        assertAll(
                () -> assertTrue(MALE_NAMES.contains(splitResult[0])),
                () -> assertTrue(BasicSurnames.SURNAMES.contains(splitResult[1]))
        );
    }

    @Test
    void shouldReturnStringWithOneMrMaleName() {
        // given
        // when
        var result = MaleName.withMr().generate();

        // then
        var splitResult = result.split("\\s");
        assertAll(
                () -> assertEquals(splitResult[0], Gender.MR.getSignOfRespect()),
                () -> assertTrue(MALE_NAMES.contains(splitResult[1]))
        );
    }

    @DisplayName("Return list of male names")
    @ParameterizedTest(name = "that contains {0} elements")
    @CsvSource({"1", "2", "7"})
    void shouldReturnListWithMaleNames(int numberOfNames) {
        // given

        // when
        var result = MaleName.numberOfNames(numberOfNames).generate();

        // then
        assertAll(
                () -> assertEquals(numberOfNames, result.size()),
                () -> assertTrue(MALE_NAMES.containsAll(result)),
                () -> assertFalse(FEMALE_NAMES.containsAll(result))
        );
    }

}
