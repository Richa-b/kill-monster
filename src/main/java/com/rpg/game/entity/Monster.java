package com.rpg.game.entity;

import com.rpg.enums.WeaponType;
import com.rpg.game.Weapon;
import com.rpg.util.KillMonsterConstants;

import static com.rpg.util.KillMonsterConstants.BASE_MONSTER_HP;
import static com.rpg.util.KillMonsterConstants.DEFAULT_LEVEL;

public class Monster extends Character {

    public Monster(String name, String description) {
        new Monster(name, description, DEFAULT_LEVEL);
    }

    public Monster(String name, String description, Integer level) {
        this.name = name;
        this.description = description;
        setHp(level);
        createDefaultWeaponListForMonster(level);
    }

    public void setHp(Integer level) {
        super.setHp(Integer.max(level * BASE_MONSTER_HP, 100));
    }

    public static Monster createDefaultMonster() {
        return new Monster("Monster Dinosaur", "");
    }

    private void createDefaultWeaponListForMonster(Integer currentLevel) {
        weaponList.add(new Weapon(WeaponType.GUN, currentLevel * KillMonsterConstants.BASE_MONSTER_GUN_COUNT));
        weaponList.add(new Weapon(WeaponType.ARROW, currentLevel * KillMonsterConstants.BASE_MONSTER_ARROW_COUNT));
        weaponList.add(new Weapon(WeaponType.KNIFE, currentLevel * KillMonsterConstants.BASE_MONSTER_KNIFE_COUNT));
        if (currentLevel > 3) {
            weaponList.add(new Weapon(WeaponType.SWORD, currentLevel * KillMonsterConstants.BASE_MONSTER_SWORD_COUNT));
            weaponList.add(new Weapon(WeaponType.BOMB, currentLevel * KillMonsterConstants.BASE_MONSTER_BOMB_COUNT));
        }
    }
}
