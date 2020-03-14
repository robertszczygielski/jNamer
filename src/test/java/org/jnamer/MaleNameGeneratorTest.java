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

class NameGeneratorTest {

    @Test
    void shouldReturnStringWithOneRandomName() {
        // given
        var allName = Stream.concat(MALE_NAMES.stream(), FEMALE_NAMES.stream());

        // when
        var result = NameGenerator.generate();

        //then
        assertTrue(allName.anyMatch(it -> it.equals(result)));
    }

    @Test
    void shouldReturnStringWithOneMaleName() {
        // given
        // when
        var result = MaleName.generateOne();

        // then
        assertTrue(MALE_NAMES.contains(result));
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

    @Test
    void shouldReturnStringWithOneFemaleName() {
        // given
        // when
        var result = NameGenerator.generateFemaleName();

        //then
        assertTrue(FEMALE_NAMES.contains(result));
    }

    @DisplayName("Return list of male and female names")
    @ParameterizedTest(name = "that contains {0} elements")
    @CsvSource({"1", "2", "7"})
    void shouldReturnListWithNames(int numberOfNames) {
        // given
        var allName = Stream.concat(MALE_NAMES.stream(), FEMALE_NAMES.stream()).collect(Collectors.toList());

        // when
        var result = NameGenerator.generate(numberOfNames);

        // then
        assertAll(
                () -> assertEquals(numberOfNames, result.size()),
                () -> assertTrue(allName.containsAll(result))
        );
    }

    @DisplayName("Return list of male names")
    @ParameterizedTest(name = "that contains {0} elements")
    @CsvSource({"1", "2", "7"})
    void shouldReturnListWithMaleNames(int numberOfNames) {
        // given

        // when
        var result = NameGenerator.generateMaleName(numberOfNames);

        // then
        assertAll(
                () -> assertEquals(numberOfNames, result.size()),
                () -> assertTrue(MALE_NAMES.containsAll(result)),
                () -> assertFalse(FEMALE_NAMES.containsAll(result))
        );
    }

    @DisplayName("Return list of female names")
    @ParameterizedTest(name = "that contains {0} elements")
    @CsvSource({"1", "2", "7"})
    void shouldReturnListWithFemaleNames(int numberOfNames) {
        // given

        // when
        var result = NameGenerator.generateFemaleName(numberOfNames);

        // then
        assertAll(
                () -> assertEquals(numberOfNames, result.size()),
                () -> assertTrue(FEMALE_NAMES.containsAll(result)),
                () -> assertFalse(MALE_NAMES.containsAll(result))
        );
    }

}
