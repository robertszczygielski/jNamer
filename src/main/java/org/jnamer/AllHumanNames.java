package org.jnamer;

import java.util.List;

public interface AllHumanNames {

    static String generateOne() {
        return BasicNames.getRandomName();
    }

    static AllHumanNames numberOfNames(int numberOfNames) {
        return new AllHumanNameGenerator(numberOfNames);
    }

    List<String> generate();
}
