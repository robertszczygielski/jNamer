package org.jnamer;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class MaleNameGenerator<T> extends HumansNameGenerator<T> {

    MaleNameGenerator() {
    }

    MaleNameGenerator(Surname<String> surnameGenerator) {
        this.surnameGenerator = surnameGenerator;
    }

    MaleNameGenerator(Gender gender) {
        this.gender = gender;
    }

    MaleNameGenerator(int numberOfNames) {
        this.numberOfNames = numberOfNames;
        this.isList = true;
    }

    @SuppressWarnings("unchecked")
    protected void generateName() {
        StringBuilder stringBuilder = new StringBuilder();

        addRespectIfPresent(stringBuilder);
        stringBuilder.append(BasicNames.getRandomMaleName());
        addSurnameIfPresent(stringBuilder);

        generated = (T) stringBuilder.toString();

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
