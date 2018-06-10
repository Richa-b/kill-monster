package com.rpg.game;

import com.rpg.enums.WeaponType;
import com.rpg.game.entity.*;
import com.rpg.game.entity.Character;
import com.rpg.game.menuManager.FightMenu;
import com.rpg.game.menuManager.Menu;
import com.rpg.io.SerializationProvider;
import com.rpg.util.IOUtil;
import com.rpg.util.KillMonsterConstants;

import java.util.List;
import java.util.Objects;

public class FightManager {

    private final Game game;

    public FightManager(Game game) {
        this.game = game;
    }

    public void startFighting() {
        Menu menu = new FightMenu();
        Player player = (Player) game.getPlayer();
        Monster monster = (Monster) game.getMonster();
        WeaponType weaponType;
        do {
            weaponType = (WeaponType) menu.showMenu(player);
            if (Objects.nonNull(weaponType)) {
                fight(weaponType);
            } else {
                SerializationProvider<Game> serializedObject = new SerializationProvider<>();
                serializedObject.serializeObject(game);
            }
        } while (monster.isAlive() && weaponType != null);
        if (player.isAlive() && Objects.nonNull(weaponType)) {
            moveToNextLevel(player);
        }
    }

    private void fight(WeaponType weaponType) {
        Player player = (Player) game.getPlayer();
        Monster monster = (Monster) game.getMonster();
        attack(weaponType, monster, player);
        if (monster.isAlive()) {
            attack(selectRandomWeaponForMonster(), player, monster);
        }
        displayHp();
        if (player.isDead()) {
            GameManager.endGame();
        } else {
            player.receiveCoins();
        }
        if (player.isUnarmed()) {
            IOUtil.showMessage("You are out of Weapons.. Shop For some weapon to fight");
            ShopManager shopManager = new ShopManager(player);
            shopManager.startShopping();
        }
    }

    private void displayHp() {
        IOUtil.showMessage("Player:: Hp Left " + game.getPlayer().getHp());
        IOUtil.showMessage("Monster:: Hp Left " + game.getMonster().getHp());
    }

    private void attack(WeaponType weaponType, Character enemy, Character attacker) {
        int damage = 0;
        if (Objects.nonNull(weaponType)) {
            damage = weaponType.attack();
            enemy.manageDamage(damage);
            attacker.manageWeapon(weaponType);
        }
        IOUtil.showMessage(attacker.getName() + " has done " + damage + " damage to the " + enemy.getName());
    }

    private WeaponType selectRandomWeaponForMonster() {
        if (!game.getMonster().isUnarmed()) {
            List<Weapon> weapons = game.getMonster().getWeaponList();
            int randomIndex = (int) (Math.random() * weapons.size());
            return weapons.get(randomIndex).getWeaponType();
        }
        return null;
    }

    private void moveToNextLevel(Player currentPlayer) {
        IOUtil.showMessage("Whoaaaa!!!! You have killed the monster");
        currentPlayer.levelUp();
        if (currentPlayer.getLevel() > KillMonsterConstants.HIGHEST_LEVEL) {
            IOUtil.showMessage("Congratulations!!!You have Passed all the levels. Game Over..");
            GameManager.exitGame();
        }
        ((Monster) game.getMonster()).increaseMonsterPowerOnLevelUp(currentPlayer.getLevel());
        startFighting();
    }
}
