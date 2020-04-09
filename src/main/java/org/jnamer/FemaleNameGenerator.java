package org.jnamer;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FemaleNameGenerator<T> extends HumansNameGenerator<T> {

    FemaleNameGenerator() {
    }

    FemaleNameGenerator(Gender gender) {
        this.gender = gender;
    }

    FemaleNameGenerator(Surname<String> surnameGenerator) {
        this.surnameGenerator = surnameGenerator;
    }

    FemaleNameGenerator(int numberOfNames) {
        this.numberOfNames = numberOfNames;
        this.isList = true;
    }

    @SuppressWarnings("unchecked")
    protected void generateName() {
        StringBuilder stringBuilder = new StringBuilder();

        addRespectIfPresent(stringBuilder);
        stringBuilder.append(BasicNames.getRandomFemaleName());
        addSurnameIfPresent(stringBuilder);

        generated = (T) stringBuilder.toString();

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
