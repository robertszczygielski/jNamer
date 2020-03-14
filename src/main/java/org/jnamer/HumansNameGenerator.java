package org.jnamer;

abstract class HumansNameGenerator<T> implements MaleName<T>, FemaleName<T> {

    protected int numberOfNames = 1;
    protected boolean isList;
    protected boolean isRespect;
    protected Gender gender;

    protected T generated;

    HumansNameGenerator() {
    }

    HumansNameGenerator(Gender gender) {
        this.gender = gender;
        this.isRespect = true;
    }

    public HumansNameGenerator(int numberOfNames) {
        this.numberOfNames = numberOfNames;
        this.isList = true;
    }

    protected abstract void generateName();

    protected abstract void generateNames();

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
