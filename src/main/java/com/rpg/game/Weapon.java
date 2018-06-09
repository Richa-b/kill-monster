package com.rpg.game;

import com.rpg.enums.WeaponType;

public class Weapon {

    private WeaponType weaponType;
    private Integer count;

    public Weapon(WeaponType weaponType, Integer count) {
        this.weaponType = weaponType;
        this.count = count;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
