package com.rpg.game.entity;

import com.rpg.enums.WeaponType;
import com.rpg.game.Weapon;
import com.rpg.util.KillMonsterConstants;

public class Monster extends Character {

    public Monster(String name, String description) {
        this.name = name;
        this.description = description;
        this.lives = KillMonsterConstants.DEFAULT_MONSTER_LIVES;
        createDefaultWeaponListForMonster();
    }

    public static Monster createDefaultMonster(){
        return new Monster("Monster Dinosaur","");
    }

    private void createDefaultWeaponListForMonster() {
        weaponList.add(new Weapon(WeaponType.GUN, KillMonsterConstants.DEFAULT_MONSTER_GUN_COUNT));
        weaponList.add(new Weapon(WeaponType.ARROW, KillMonsterConstants.DEFAULT_MONSTER_ARROW_COUNT));
        weaponList.add(new Weapon(WeaponType.KNIFE, KillMonsterConstants.DEFAULT_MONSTER_KNIFE_COUNT));
    }
}
