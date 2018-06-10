package com.rpg.game;

import com.rpg.enums.WeaponType;
import com.rpg.game.entity.Character;
import com.rpg.game.entity.Monster;
import com.rpg.game.entity.Player;
import com.rpg.game.menuManager.FightMenu;
import com.rpg.game.menuManager.Menu;
import com.rpg.util.IOUtil;
import com.rpg.util.KillMonsterConstants;

import java.util.Objects;

public class FightManager {

    private Character player;
    private Character monster;

    public FightManager(Character player, Character monster) {
        this.player = player;
        this.monster = monster;
    }

    public void startFighting() {
        Menu menu = new FightMenu();
        Player currentPlayer = (Player) player;
        WeaponType weaponType;
        do {
            weaponType = (WeaponType) menu.showMenu(currentPlayer);
            if (Objects.nonNull(weaponType)) {
                attack(weaponType, monster, player);
                if (monster.isAlive()) {
                    //TODO: Pick random Weapon for monster
                    attack(weaponType, player, monster);
                }
                displayHp();
                if (player.isDead()) {
                    GameManager.endGame();
                } else {
                    ((Player) player).receiveCoins();
                }
                if (player.isUnarmed()) {
                    IOUtil.showMessage("You are out of Weapons.. Shop For some weapon to fight");
                    ShopManager shopManager = new ShopManager(player);
                    shopManager.startShopping();
                }
            } else {
                //TODO: save the game
            }
        } while (monster.isAlive());
        if (player.isAlive() && Objects.nonNull(weaponType)) {
           moveToNextLevel(currentPlayer);
        }
    }

    //TODO: MOve to some other class
    private void displayHp() {
        IOUtil.showMessage("Player:: Hp Left " + player.getHp() + "/" + 100);
        IOUtil.showMessage("Monster:: Hp Left " + monster.getHp() + "/" + 100);
    }

    private void attack(WeaponType weaponType, Character enemy, Character attacker) {
        int damage = weaponType.attack();
        IOUtil.showMessage(attacker.getName() + " has done " + damage + " damage to the " + enemy.getName());
        enemy.manageDamage(damage);
        attacker.manageWeapon(weaponType);
    }

    public void moveToNextLevel(Player currentPlayer){
        IOUtil.showMessage("Whoaaaa!!!! You have killed the monster");
        currentPlayer.levelUp();
        //TODO: change monster creation
        monster = new Monster("ABC", "sdkj", currentPlayer.getLevel());
        if (currentPlayer.getLevel() > KillMonsterConstants.HIGHEST_LEVEL) {
            IOUtil.showMessage("Congratulations!!!You have Passed all the levels. Game Over..");
            GameManager.exitGame();
        }
        startFighting();
    }
}
