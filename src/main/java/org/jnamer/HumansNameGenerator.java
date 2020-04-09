package org.jnamer;

import java.util.Objects;

abstract class HumansNameGenerator<T> implements MaleName<T>, FemaleName<T> {

    protected final String SPACE = " ";

    protected int numberOfNames = 1;
    protected boolean isList;
    protected Gender gender;
    protected Surname<String> surnameGenerator;

    protected T generated;

    HumansNameGenerator() {
    }

    protected abstract void generateName();

    protected abstract void generateNames();

    protected void addSurnameIfPresent(StringBuilder stringBuilder) {
        if (Objects.nonNull(surnameGenerator)) {
            stringBuilder.append(SPACE);
            stringBuilder.append(surnameGenerator.generate());
        }
    }

    protected void addRespectIfPresent(StringBuilder stringBuilder) {
        if (Objects.nonNull(gender)) {
            stringBuilder.append(gender.getSignOfRespect());
            stringBuilder.append(SPACE);
        }
    }

    @Override
    public T generate() {
        if (isList) {
            generateNames();
        } else {
            generateName();
        }

        return generated;
    }

}
