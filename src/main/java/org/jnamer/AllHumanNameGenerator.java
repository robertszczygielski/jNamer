package org.jnamer;

import java.util.List;

class AllHumanNameGenerator implements AllHumanNames {

    private int numberOfNames;

    AllHumanNameGenerator(int numberOfNames) {
        this.numberOfNames = numberOfNames;
    }

    @Override
    public List<String> generate() {
        return BasicNames.getRandomNames(numberOfNames);
    }

}
