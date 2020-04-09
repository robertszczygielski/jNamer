package org.jnamer;

import java.util.List;
import java.util.stream.IntStream;

public interface MaleName<T> extends Generatable<T> {

    static MaleName<String> withMr() {
        return new MaleNameGenerator<>(Gender.MR);
    }

    static MaleName<String> withSurname() {
        return new MaleNameGenerator<>(new SurnameGenerator<>());
    }

    static MaleName<List<String>> numberOfNames(int numberOfNames) {
        return new MaleNameGenerator<>(numberOfNames);
    }

    static String generateOne() {
        return new MaleNameGenerator<String>().generate();
    }
}
