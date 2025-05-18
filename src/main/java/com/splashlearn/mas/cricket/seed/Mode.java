package com.splashlearn.mas.cricket.seed;

public enum Mode {
    FreeHitMode("Free Hit Mode"),
    SuperMode("Super Mode"),
    PowerPlayMode("Power Play Mode"),
    WorldCupMode("World Cup Mode");

    private final String displayName;

    Mode(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return displayName;
    }
}
