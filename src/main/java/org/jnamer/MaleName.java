package org.jnamer;

import java.util.List;

public interface MaleName<T> extends AllName<T> {

    static MaleName<String> withMr() {
        return new MaleNameGenerator<>(Gender.MR);
    }

    static MaleName<List<String>> numberOfNames(int numberOfNames) {
        return new MaleNameGenerator<>(numberOfNames);
    }

    static String generateOne() {
        return new MaleNameGenerator<String>().generate();
    }

}
