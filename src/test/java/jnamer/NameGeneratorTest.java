package jnamer;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static jnamer.BasicNames.FEMALE_NAMES;
import static jnamer.BasicNames.MALE_NAMES;
import static org.junit.jupiter.api.Assertions.*;

public class NameGeneratorTest {

    @Test
    void shouldReturnStringWithOneRandomName() {
        // given
        var allName = Stream.concat(MALE_NAMES.stream(), FEMALE_NAMES.stream());

        // when
        var result = NameGenerator.generateOneName();

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
}
