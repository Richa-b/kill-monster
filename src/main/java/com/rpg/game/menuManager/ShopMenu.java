package com.rpg.game.menuManager;

import com.rpg.enums.WeaponType;
import com.rpg.game.entity.Player;
import com.rpg.util.IOUtil;

import java.util.Arrays;
import java.util.List;

public class ShopMenu implements Menu {
    @Override
    public Object showMenu(Player player) {
        List<WeaponType> weapons = Arrays.asList(WeaponType.values());
        IOUtil.showMessage("Which weapon do you want to buy!!!");
        displayOptions(weapons);
        Integer selectedOption = selectOption(weapons);
        if (selectedOption == 0) {
            return null;
        }
        return weapons.get(selectedOption - 1);
    }

    private void displayOptions(List<WeaponType> weapons) {
        WeaponType weaponType;
        for (int i = 0; i < weapons.size(); i++) {
            weaponType = weapons.get(i);
            IOUtil.showMessage((i + 1) + "." + weaponType.getDisplayName() + " " + weaponType.getAsciiArt() + " (" +
                    weaponType.getCoinsPerWeapon() + " Coins)" + "\n");
        }
        IOUtil.showMessage("Press 0 to Leave");
    }
}
