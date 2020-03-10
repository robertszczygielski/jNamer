package org.jnamer;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BasicSurnames {

    private static Random random = new Random();

    final static List<String> SURNAMES = Arrays.asList(
            "Smith", "Kumar", "Latu", "Gonzalez", "Rodriguez",
            "Da Silva", "Hernandez", "Murphy", "De Jong",
            "Perera", "Nguyen", "Wang", "Devi", "Nkosi"
    );

    public static String generate() {
        return SURNAMES.get(random.nextInt(numberOfSurnames()));
    }

    private static int numberOfSurnames() {
        return SURNAMES.size();
    }

    public static List<String> generate(int numberOfSurnames) {
        return IntStream.range(0, numberOfSurnames)
                .mapToObj(it -> {
                    return generate();
                })
                .collect(Collectors.toList());
    }
}
