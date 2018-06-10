package com.rpg.enums;

public enum WelcomeMenuType {

    START("Let's Start The Game"),
    RELOAD("Reload Existing Game"),
    EXIT("No, I want to exit");

    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    WelcomeMenuType(String displayName) {
        this.displayName = displayName;
    }
}
