package com.rpg.enums;

import com.rpg.util.AsciiArt;

public enum WeaponType {

    GUN("Gun", AsciiArt.GUN, "", 5,1),
    ARROW("Arrow", AsciiArt.ARROW, "", 10,2),
    KNIFE("Knife", AsciiArt.KNIFE, "", 15,5),
    SWORD("Sword", AsciiArt.SWORD, "", 25,10),
    BOMB("Bomb", AsciiArt.BOMB, "", 50,20);

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

    public int attack(){
        return (int )(Math.random() * this.getStrength() + 1);
    }

    WeaponType(String displayName, String asciiArt, String description, Integer coinsRequired, Integer strength) {
        this.displayName = displayName;
        this.asciiArt = asciiArt;
        this.description = description;
        this.coinsPerWeapon = coinsRequired;
        this.strength = strength;
    }


}
