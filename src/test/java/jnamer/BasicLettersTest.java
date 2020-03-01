package jnamer;

import exceptions.JNamerNoIndexException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BasicLettersTest {

    @ParameterizedTest
    @CsvSource({"0,a", "1,b", "25,z"})
    void shouldReturnLowerLetterWhenGetLowerLetterIsCalled(int index, String expected)
            throws JNamerNoIndexException {
        // given

        // when
        String result = BasicLetters.getLowerLetter(index);

        // then
        assertEquals(expected, result);

    }

    @ParameterizedTest
    @CsvSource({"0,A", "1,B", "25,Z"})
    void shouldReturnUpperLetterWhenGetUpperLetterIsCalled(int index, String expected)
            throws JNamerNoIndexException {
        // given

        // when
        String result = BasicLetters.getUpperLetter(index);

        // then
        assertEquals(expected, result);

    }

    @ParameterizedTest
    @CsvSource({"-1", "26"})
    void shouldThrowJNamerNoIndexExceptionWhenTheIndexIsNotInRange(int outOfBoundIndex) {
        // given

        // when
        Assertions.assertThrows(
                JNamerNoIndexException.class,
                () -> {
                    BasicLetters.getLowerLetter(outOfBoundIndex);
                });

        // then
    }

    @ParameterizedTest
    @CsvSource({"1", "2533"})
    void shouldReturnLowerLetterStringForGivenNumberOfCharacters(int expectedLength) {
        // given
        var regex = "[a-z]+";

        // when
        var result = BasicLetters.getRandomLowerLetters(expectedLength);

        // then
        assertAll(
                () -> assertEquals(expectedLength, result.length()),
                () -> assertTrue(result.matches(regex))
        );
    }

    @ParameterizedTest
    @CsvSource({"1", "2533"})
    void shouldReturnUpperLetterStringForGivenNumberOfCharacters(int expectedLength) {
        // given
        var regex = "[A-Z]+";

        // when
        var result = BasicLetters.getRandomUpperLetters(expectedLength);

        // then
        assertAll(
                () -> assertEquals(expectedLength, result.length()),
                () -> assertTrue(result.matches(regex))
        );
    }

    @ParameterizedTest
    @CsvSource({"3", "2533"})
    void shouldReturnStringWithDifferentLetterSizesForGivenNumberOfCharacters(int expectedLength) {
        // given
        String regex = "[A-Za-z]+";

        // when
        var result = BasicLetters.getRandomLetters(expectedLength);

        // then
        assertAll(
                () -> assertEquals(expectedLength, result.length()),
                () -> assertTrue(result.matches(regex))
        );
    }

    @Test
    void shouldReturnStringWithDifferentLetterSizesForNonNumberOfCharacters() {
        // given

        // when
        var result = BasicLetters.getRandomLetters();

        // then
        assertFalse(result.isBlank());
    }

    @Test
    void shouldReturnEmptyStringForRandomLettersWhenParameterIsMinusOne() {
        // given
        var minusOne = -1;

        // when
        var result = BasicLetters.getRandomLetters(minusOne);

        // then
        assertAll(
                () -> assertTrue(result.isBlank()),
                () -> assertTrue(result.isEmpty())
        );
    }

    @Test
    void shouldReturnEmptyStringForRandomLowerLettersWhenParameterIsMinusOne() {
        // given
        var minusOne = -1;

        // when
        var result = BasicLetters.getRandomLowerLetters(minusOne);

        // then
        assertAll(
                () -> assertTrue(result.isBlank()),
                () -> assertTrue(result.isEmpty())
        );
    }

    @Test
    void shouldReturnEmptyStringForRandomUpperLettersWhenParameterIsMinusOne() {
        // given
        var minusOne = -1;

        // when
        var result = BasicLetters.getRandomUpperLetters(minusOne);

        // then
        assertAll(
                () -> assertTrue(result.isBlank()),
                () -> assertTrue(result.isEmpty())
        );
    }
}
