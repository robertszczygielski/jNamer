package org.jnamer;

import java.util.List;

public class NameGenerator {

    public static String generate() {
        return BasicNames.getRandomName();
    }

    public static String generateMaleName() {
        return BasicNames.getRandomMaleName();
    }

    public static String generateFemaleName() {
        return BasicNames.getRandomFemaleName();
    }

    public static List<String> generate(int numberOfNames) {
        return BasicNames.getRandomNames(numberOfNames);
    }

    public static List<String> generateMaleName(int numberOfNames) {
        return BasicNames.getRandomMaleNames(numberOfNames);
    }

    public static List<String> generateFemaleName(int numberOfNames) {
        return BasicNames.getRandomFemaleNames(numberOfNames);
    }
}
