package org.jnamer;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SurnameGenerator<T> implements Surname<T>{

    private int numberOfSurnames = 1;
    private boolean isList;

    private T generated;

    public SurnameGenerator() {
    }

    public SurnameGenerator(int numberOfSurnames) {
        this.numberOfSurnames = numberOfSurnames;
        this.isList = true;
    }

    @Override
    public T generate() {
        if (isList) {
            generateSurnames();
        } else {
            generateSurname();
        }

        return generated;
    }

    @SuppressWarnings("unchecked")
    private void generateSurname() {
        generated = (T) BasicSurnames.generate();
    }

    @SuppressWarnings("unchecked")
    public void generateSurnames() {
        generated =
                (T) IntStream
                .range(0, numberOfSurnames)
                .mapToObj(it -> BasicSurnames.generate())
                .collect(Collectors.toList());
    }
}
