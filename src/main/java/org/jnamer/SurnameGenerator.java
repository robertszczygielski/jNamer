package org.jnamer;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class SurnameGenerator {

    private static Random random = new Random();

    final static List<String> SURNAMES = Arrays.asList(
            "Smith", "Kumar", "Latu", "Gonzalez", "Rodriguez",
            "Da Silva", "Hernandez", "Murphy", "De Jong",
            "Perera", "Nguyen", "Wang", "Devi", "Nkosi"
    );

    public static String generateOne() {
        return SURNAMES.get(random.nextInt(numberOfSurnames()));
    }

    private static int numberOfSurnames() {
        return SURNAMES.size();
    }
}
