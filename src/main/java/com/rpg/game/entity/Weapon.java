package com.rpg.game.entity;

import com.rpg.enums.WeaponType;

import java.io.Serializable;

public class Weapon implements Serializable{

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
