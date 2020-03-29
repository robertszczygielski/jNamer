package org.jnamer;

import java.util.List;

public interface Surname<T> extends Generatable<T> {

    static String generateOne() {
        return new SurnameGenerator<String>().generate();
    }

    static Surname<List<String>> numberOfNames(int numberOfSurnames) {
        return new SurnameGenerator<>(numberOfSurnames);
    }
}
