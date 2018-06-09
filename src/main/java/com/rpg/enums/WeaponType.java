package com.rpg.enums;

import com.rpg.util.AsciiArt;

public enum WeaponType {

    GUN("Gun", AsciiArt.GUN, "", 0,1),
    ARROW("Arrow", AsciiArt.ARROW, "", 5,2),
    KNIFE("Knife", AsciiArt.KNIFE, "", 10,5),
    SWORD("Sword", AsciiArt.SWORD, "", 25,10),
    BOMB("Bomb", AsciiArt.BOMB, "", 50,15);

    private String displayName;
    private String asciiArt;
    private String description;
    private Integer coinsPerWeapon;
    private Integer strength;

    public String getDisplayName() {
        return displayName;
    }

    public String getAsciiArt() {
        return asciiArt;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCoinsPerWeapon() {
        return coinsPerWeapon;
    }

    public Integer getStrength() {
        return strength;
    }

    WeaponType(String displayName, String asciiArt, String description, Integer coinsRequired, Integer strength) {
        this.displayName = displayName;
        this.asciiArt = asciiArt;
        this.description = description;
        this.coinsPerWeapon = coinsRequired;
        this.strength = strength;
    }


}
