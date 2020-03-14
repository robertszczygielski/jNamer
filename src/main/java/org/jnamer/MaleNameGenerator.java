package org.jnamer;

class BasicMaleNames implements MaleName {

    private StringBuilder stringBuilder = new StringBuilder();

    BasicMaleNames() {

    }

    BasicMaleNames(Gender gender) {
        stringBuilder.append(gender.getSignOfRespect());
        stringBuilder.append(" ");
    }

    @Override
    public String generate() {
        String maleName = BasicNames.getRandomMaleName();
        stringBuilder.append(maleName);

        return stringBuilder.toString();
    }
}
