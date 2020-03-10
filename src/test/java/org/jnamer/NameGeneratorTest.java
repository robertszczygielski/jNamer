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
        var result = NameGenerator.generateOne();

        //then
        assertTrue(allName.anyMatch(it -> it.equals(result)));
    }

    @Test
    void shouldReturnStringWithOneMaleName() {
        // given
        // when
        var result = NameGenerator.generateOneMaleName();

        //then
        assertTrue(MALE_NAMES.contains(result));
    }

    @Test
    void shouldReturnStringWithOneFemaleName() {
        // given
        // when
        var result = NameGenerator.generateOneFemaleName();

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
        var result = NameGenerator.generateMulti(numberOfNames);

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
        var result = NameGenerator.generateMultiMale(numberOfNames);

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
        var result = NameGenerator.generateMultiFemale(numberOfNames);

        // then
        assertAll(
                () -> assertEquals(numberOfNames, result.size()),
                () -> assertTrue(FEMALE_NAMES.containsAll(result)),
                () -> assertFalse(MALE_NAMES.containsAll(result))
        );
    }

}
