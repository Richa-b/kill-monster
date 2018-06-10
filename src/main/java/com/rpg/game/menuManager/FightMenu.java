package com.rpg.game.menuManager;


import com.rpg.enums.WeaponType;
import com.rpg.game.entity.Weapon;
import com.rpg.game.entity.Player;
import com.rpg.util.IOUtil;

import java.util.List;

public class FightMenu implements Menu {


    @Override
    public Object showMenu(Player player) {
        List<Weapon> weapons = player.getWeaponList();
        IOUtil.showMessage("Select a Weapon");
        displayOptions(weapons);
        Integer selectedOption = selectOption(weapons);
        if (selectedOption == 0) {
            return null;
        }
        return weapons.get(selectedOption - 1).getWeaponType();
    }

    private void displayOptions(List<Weapon> weapons) {
        WeaponType weaponType;
        for (int i = 0; i < weapons.size(); i++) {
            weaponType = weapons.get(i).getWeaponType();
            IOUtil.showMessage((i + 1) + "." + weaponType.getDisplayName() + " " + weaponType.getAsciiArt() + "\n");
        }
        IOUtil.showMessage("Press 0 for Save and Exit");
    }

}
