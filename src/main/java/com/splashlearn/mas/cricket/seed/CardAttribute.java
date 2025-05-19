package com.splashlearn.mas.cricket.seed;

public enum CardAttribute {
    RUNS("Runs", 100_001),
    MATCHES("Matches", 501),
    CENTURIES("Centuries", 101),
    HALF_CENTURIES("Half centuries", 81),
    CATCHES("Catches", 381),
    WICKETS("Wickets", 961);

    private final String displayName;
    private final int maxRange;

    CardAttribute(String displayName, int maxRange) {
        this.displayName = displayName;
        this.maxRange = maxRange;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getMaxRange() {
        return maxRange;
    }
}
