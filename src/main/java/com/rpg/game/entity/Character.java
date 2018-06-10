package com.rpg.game.entity;

import com.rpg.enums.WeaponType;
import com.rpg.game.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Character {
    protected String name;
    protected Integer hp;
    protected String description;

    public void manageDamage(int damage) {
        hp = hp - damage;
    }

    public void manageWeapon(WeaponType weaponType) {
        Weapon existingWeapon = getWeaponFromType(weaponType);
        if (Objects.nonNull(existingWeapon)) {
            existingWeapon.setCount(existingWeapon.getCount() - 1);
            if (existingWeapon.getCount() <= 0) {
                weaponList.remove(existingWeapon);
            }
        }
    }

    public void addWeapon(WeaponType weaponType) {
        Weapon existingWeapon = getWeaponFromType(weaponType);
        if (Objects.nonNull(existingWeapon)) {
            existingWeapon.setCount(existingWeapon.getCount() + 1);
        } else {
            weaponList.add(new Weapon(weaponType, 1));
        }
    }

    private Weapon getWeaponFromType(WeaponType weaponType) {
        return weaponList.stream()
                .filter(weapon -> weaponType.equals(weapon.getWeaponType()))
                .findFirst()
                .orElse(null);
    }


    public Boolean isAlive() {
        return hp > 0;
    }

    public Boolean isUnarmed() {
        return weaponList.size() == 0;
    }

    public Boolean isDead() {
        return hp <= 0;
    }

    public Boolean isAboutToDie() {
        return hp <= 20;
    }

    public String getName() {
        return name;
    }

    public Integer getHp() {
        return hp;
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

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeaponList(List<Weapon> weaponList) {
        this.weaponList = weaponList;
    }

    protected List<Weapon> weaponList = new ArrayList<>();

}
