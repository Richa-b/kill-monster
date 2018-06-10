package com.rpg.game;

import com.rpg.enums.ActionType;
import com.rpg.game.entity.Character;
import com.rpg.game.entity.Player;
import com.rpg.game.menuManager.ActionMenu;
import com.rpg.game.menuManager.Menu;
import com.rpg.util.IOUtil;

import java.util.List;

public class ActionManager {

    private Character player;
    private Character monster;

    public ActionManager(Character player, Character monster) {
        this.player = player;
        this.monster = monster;
    }

    public void performOperation() {
        Menu menu = new ActionMenu();
        ActionType actionType;
        do {
            actionType = (ActionType) menu.showMenu((Player) player);
            switch (actionType) {
                case FIGHT:
                    fight();
                    break;
                case SHOP:
                    shop();
                    break;
                case STATS:
                    stats();
                    break;
                case INVENTORY:
                    inventory();
                    break;
            }
        } while (!ActionType.EXIT.equals(actionType));
    }

    private void fight() {
        FightManager fight = new FightManager(player, monster);
        fight.startFighting();
        stats();
        inventory();
    }

    private void shop() {
        ShopManager shopManager = new ShopManager(player);
        shopManager.startShopping();
        stats();
        inventory();

    }

    private void stats() {
        Player p = (Player) player;
        IOUtil.showMessage("-----------------------------------------");
        IOUtil.showMessage("You have " + p.getHp() + " hp left.");
        IOUtil.showMessage("You have " + p.getCoins() + " coins.");
        IOUtil.showMessage("You are at level " + p.getLevel());
        IOUtil.showMessage("-----------------------------------------");
    }

    private void inventory() {
        List<Weapon> weaponList = player.getWeaponList();
        IOUtil.showMessage("-----------------------------------------");
        weaponList.stream().forEach(weapon ->
                IOUtil.showMessage("You have " + weapon.getCount() + " " + weapon.getWeaponType().getDisplayName() + " (s)"));
        IOUtil.showMessage("-----------------------------------------");
    }

}
