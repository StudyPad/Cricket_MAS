package com.splashlearn.mas.cricket.enums;

public enum SpecialModeEnum {
    FREE_HIT(1, "Free Hit Mode"),
    POWER_PLAY(2, "Power Play Mode"),
    WORLD_CUP(3, "World Cup Mode"),
    SUPER(4, "Super Mode");

    private final int id;
    private final String name;

    SpecialModeEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
