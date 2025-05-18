package com.splashlearn.mas.cricket.seed;

public enum CardAttribute {
    RUNS("Runs"),
    MATCHES("Matches"),
    CENTURIES("Centuries"),
    HALF_CENTURIES("Half centuries"),
    CATCHES("Catches"),
    WICKETS("Wickets");

    private final String displayName;

    CardAttribute(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return displayName;
    }
}
