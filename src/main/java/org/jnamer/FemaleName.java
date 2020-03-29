package org.jnamer;

import java.util.List;

public interface FemaleName<T> extends Generatable<T> {

    static FemaleName<String> withMs() {
        return new FemaleNameGenerator<>(Gender.MS);
    }

    static FemaleName<List<String>> numberOfNames(int numbersOfNames) {
        return new FemaleNameGenerator<>(numbersOfNames);
    }

    static String  generateOne() {
        return new FemaleNameGenerator<String>().generate();
    }
}
