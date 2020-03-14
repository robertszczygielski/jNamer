package org.jnamer;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FemaleNameGenerator<T> extends HumansNameGenerator<T> {

    FemaleNameGenerator() {
    }

    FemaleNameGenerator(Gender gender) {
        super(gender);
    }

    FemaleNameGenerator(int numberOfNames) {
        super(numberOfNames);
    }

    @SuppressWarnings("unchecked")
    protected void generateName() {
        String name = BasicNames.getRandomFemaleName();
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
                        .mapToObj(it -> BasicNames.getRandomFemaleName())
                        .collect(Collectors.toList());
    }
}
