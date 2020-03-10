package org.jnamer;

import java.util.List;

class SurnameGenerator {

    public static String generate() {
        return BasicSurnames.generate();
    }

    public static List<String> generate(int numberOfSurnames) {
        return BasicSurnames.generate(numberOfSurnames);
    }
}
