package com.rpg.game;

import com.rpg.enums.WeaponType;
import com.rpg.game.entity.Character;
import com.rpg.game.entity.Player;
import com.rpg.game.menuManager.Menu;
import com.rpg.game.menuManager.ShopMenu;
import com.rpg.util.IOUtil;

import java.util.Objects;

public class ShopManager {

    private Character player;

    public ShopManager(Character player) {
        this.player = player;
    }

    public void startShopping() {
        Menu menu = new ShopMenu();
        WeaponType weaponType;
        do {
            weaponType = (WeaponType) menu.showMenu((Player) player);
            if (Objects.nonNull(weaponType)) {
                if (weaponType.getCoinsPerWeapon() > ((Player) player).getCoins()) {
                    IOUtil.showMessage("###############################################################");
                    IOUtil.showMessage("You do not have enough coins to buy " + weaponType.getDisplayName());
                    IOUtil.showMessage("###############################################################");
                } else {
                    player.addWeapon(weaponType);
                    ((Player) player).decrementCoins(weaponType);
                }
            }
        } while (weaponType != null);
    }

}
