package com.rpg.enums;

public enum ActionType {

    FIGHT("Fight"),
    SHOP("Shop"),
    STATS("Statistics"),
    INVENTORY("Inventory"),
    EXIT("Exit");

    public String getDisplayName() {
        return displayName;
    }

    private String displayName;

    ActionType(String displayName) {
        this.displayName = displayName;
    }
}
