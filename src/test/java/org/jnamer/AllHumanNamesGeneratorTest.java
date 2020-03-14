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

class AllHumanNamesGeneratorTest {

    @Test
    void shouldReturnStringWithOneRandomName() {
        // given
        var allName = Stream.concat(MALE_NAMES.stream(), FEMALE_NAMES.stream());

        // when
        var result = AllHumanNames.generateOne();

        //then
        assertTrue(allName.anyMatch(it -> it.equals(result)));
    }

    @DisplayName("Return list of male and female names")
    @ParameterizedTest(name = "that contains {0} elements")
    @CsvSource({"1", "2", "7"})
    void shouldReturnListWithNames(int numberOfNames) {
        // given
        var allName = Stream.concat(MALE_NAMES.stream(), FEMALE_NAMES.stream()).collect(Collectors.toList());

        // when
        var result = AllHumanNames.numberOfNames(numberOfNames).generate();

        // then
        assertAll(
                () -> assertEquals(numberOfNames, result.size()),
                () -> assertTrue(allName.containsAll(result))
        );
    }

}
