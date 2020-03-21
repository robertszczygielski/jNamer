package org.jnamer;

public enum Gender {
    MR("Mr."),
    MS("Ms.")
    ;

    private final String signOfRespect;

    Gender(String signOfRespect) {
        this.signOfRespect = signOfRespect;
    }

    public String getSignOfRespect() {
        return signOfRespect;
    }
}
