package com.rpg.game;

import com.rpg.enums.WeaponType;
import com.rpg.game.entity.Character;
import com.rpg.game.entity.Player;
import com.rpg.game.menuManager.FightMenu;
import com.rpg.game.menuManager.Menu;
import com.rpg.util.IOUtil;

public class Fight {

    private final Character player;
    private final Character monster;

    public Fight(Character player, Character monster) {
        this.player = player;
        this.monster = monster;
    }

    public void startFighting() throws Exception {
        Menu menu = new FightMenu();
        do {
            WeaponType weaponType = (WeaponType) menu.showMenu((Player) player);
            attack(weaponType, monster, player);
            if (monster.isAlive()) {
                attack(weaponType, player, monster);
            }
            if (player.isDead()) {
                Game.endGame();
            }
        } while (monster.isAlive());
        if (player.isAlive()) {
            ((Player) player).receiveCoins();
            IOUtil.showMessage("Move to Next Level");
        }

    }


    public void attack(WeaponType weaponType, Character enemy, Character attacker) {
        int damage = weaponType.attack();
        IOUtil.showMessage(attacker.getName() + " has done " + damage + " damage to the " + enemy.getName());
        enemy.manageDamage(damage);
        attacker.manageWeapon(weaponType);
    }
}
