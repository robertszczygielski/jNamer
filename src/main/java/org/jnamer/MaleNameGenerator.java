package org.jnamer;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class MaleNameGenerator<T> extends HumansNameGenerator<T> {

    MaleNameGenerator() {
    }

    MaleNameGenerator(Gender gender) {
        super(gender);
    }

    MaleNameGenerator(int numberOfNames) {
        super(numberOfNames);
    }


    @SuppressWarnings("unchecked")
    protected void generateName() {
        String name = BasicNames.getRandomMaleName();
        if (isRespect) {
            generated = (T) nameWithRespect(name);
        } else {
            generated = (T) name;
        }
    }

    private String nameWithRespect(String name) {
        return gender.getSignOfRespect() + " " + name;
    }

    @SuppressWarnings("unchecked")
    protected void generateNames() {
        generated =
                (T) IntStream
                        .range(0, numberOfNames)
                        .mapToObj(it -> BasicNames.getRandomMaleName())
                        .collect(Collectors.toList());
    }
}
