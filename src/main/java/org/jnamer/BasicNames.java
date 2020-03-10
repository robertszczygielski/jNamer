package org.jnamer;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicNames {

    private static Random random = new Random();

    static final List<String> MALE_NAMES = Arrays.asList(
            "Liam", "Noah", "William", "James", "Oliver", "Benjamin",
            "Elijah", "Lucas", "Mason", "Logan", "Alexander", "Ethan",
            "Jacob", "Michael", "Daniel", "Henry", "Jackson", "Sebastian",
            "Aiden", "Matthew"
    );

    static final List<String> FEMALE_NAMES = Arrays.asList(
            "Emma", "Olivia", "Ava", "Isabella", "Sophia", "Charlotte",
            "Mia", "Amelia", "Harper", "Evelyn", "Abigail", "Emily",
            "Elizabeth", "Mila", "Ella", "Avery", "Sofia", "Camila",
            "Aria", "Scarlett"
    );

    static String getRandomName() {
        var allName = Stream.concat(
                MALE_NAMES.stream(),
                FEMALE_NAMES.stream())
                .collect(Collectors.toList());

        return allName.get(random.nextInt(numberOfAllNames()));
    }

    static List<String> getRandomNames(int numberOfNames) {
        return IntStream.range(0, numberOfNames)
                .mapToObj(it -> {
                    return getRandomName();
                })
                .collect(Collectors.toList());
    }

    static String getRandomMaleName() {
        return MALE_NAMES.get(random.nextInt(numberOfMaleNames()));
    }

    static String getRandomFemaleName() {
        return FEMALE_NAMES.get(random.nextInt(numberOfFemaleNames()));
    }

    private static int numberOfAllNames() {
        return MALE_NAMES.size() + FEMALE_NAMES.size();
    }

    private static int numberOfMaleNames() {
        return MALE_NAMES.size();
    }

    public static List<String> getRandomMaleNames(int numberOfNames) {
        return IntStream.range(0, numberOfNames)
                .mapToObj(it -> {
                    return getRandomMaleName();
                })
                .collect(Collectors.toList());
    }

    private static int numberOfFemaleNames() {
        return FEMALE_NAMES.size() ;
    }

    public static List<String> getRandomFemaleNames(int numberOfNames) {
        return IntStream.range(0, numberOfNames)
                .mapToObj(it -> {
                    return getRandomFemaleName();
                })
                .collect(Collectors.toList());
    }
}
