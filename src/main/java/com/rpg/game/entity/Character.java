package com.rpg.game.entity;

import com.rpg.enums.WeaponType;
import com.rpg.game.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Character {
    protected String name;
    protected Integer lives;
    protected String description;

    public void manageDamage(int damage) {
        lives = lives - damage;
    }

    public void manageWeapon(WeaponType weaponType) {
        Weapon existingWeapon = weaponList.stream()
                .filter(weapon -> weaponType.equals(weapon.getWeaponType()))
                .findFirst()
                .orElse(null);
        if (Objects.nonNull(existingWeapon)) {
            existingWeapon.setCount(existingWeapon.getCount() - 1);
            if (existingWeapon.getCount() <= 0) {
                weaponList.remove(existingWeapon);
            }
        }
    }

    public Boolean isAlive() {
        return lives > 0;
    }

    public Boolean isUnarmed() {
        return weaponList.size() == 0;
    }

    public Boolean isDead() {
        return lives <= 0;
    }

    public String getName() {
        return name;
    }

    public Integer getLives() {
        return lives;
    }

    public String getDescription() {
        return description;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLives(Integer lives) {
        this.lives = lives;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeaponList(List<Weapon> weaponList) {
        this.weaponList = weaponList;
    }

    protected List<Weapon> weaponList = new ArrayList<>();

}
