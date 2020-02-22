package alphabet;

import exceptions.JNamerNoIndexException;

import java.util.Random;
import java.util.stream.IntStream;

public class BasicLetters {

    public static String getUpperLetter(int index) throws JNamerNoIndexException {
        return getLowerLetter(index).toUpperCase();
    }

    public static String getLowerLetter(int index) throws JNamerNoIndexException {
        if (index < 0 || index > BasicAlphabet.maxIndex()) {
            throw new JNamerNoIndexException();
        }

        return BasicAlphabet.letters.get(index);
    }

    public static String getRandomUpperLetters(int length) {
        return getRandomLowerLetters(length).toUpperCase();
    }

    public static String getRandomLowerLetters(int length) {
        Random rand = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(0, length)
                .forEach(it -> {
                    var idx = rand.nextInt(BasicAlphabet.maxIndex() + 1);
                    try {
                        stringBuilder.append(getLowerLetter(idx));
                    } catch (JNamerNoIndexException e) {
                        e.printStackTrace();
                    }
                });

        return stringBuilder.toString();
    }

    public static String getRandomLetters(int length) {
        var lowerLetters = getRandomLowerLetters(length);

        Random rand = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        lowerLetters.chars().forEach(it -> {
            stringBuilder.append(
                    rand.nextBoolean()
                            ? Character.toString(it).toUpperCase()
                            : Character.toString(it));
        });

        return stringBuilder.toString();
    }

    public static String getRandomLetters() {
        Random rand = new Random();
        return getRandomLetters(rand.nextInt(1024) + 1);
    }
}
