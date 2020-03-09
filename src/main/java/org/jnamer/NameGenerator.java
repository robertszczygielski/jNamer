package org.jnamer;

import java.util.List;

public class NameGenerator {

    public static String generateOne() {
        return BasicNames.getRandomName();
    }

    public static String generateOneMaleName() {
        return BasicNames.getRandomMaleName();
    }

    public static String generateOneFemaleName() {
        return BasicNames.getRandomFemaleName();
    }

    public static List<String> generateMulti(int numberOfNames) {
        return BasicNames.getRandomNames(numberOfNames);
    }

    public static List<String> generateMultiMale(int numberOfNames) {
        return BasicNames.getRandomMaleNames(numberOfNames);
    }

    public static List<String> generateMultiFemale(int numberOfNames) {
        return BasicNames.getRandomFemaleNames(numberOfNames);
    }
}
