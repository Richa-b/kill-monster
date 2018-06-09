package com.rpg.game.menuManager;

import com.rpg.exception.InvalidSelectionException;
import com.rpg.game.entity.Player;
import com.rpg.util.IOUtil;
import com.rpg.util.KillMonsterConstants;

import java.util.InputMismatchException;
import java.util.List;

public interface Menu {

    Object showMenu(Player player) throws Exception;

    default Integer selectOption(List menuItems) {
        int optionSelected;
        for (int i = 0; i < KillMonsterConstants.MAX_TRY_COUNT; i++) {
            try {
                optionSelected = IOUtil.getIntegerInput();
            } catch (InputMismatchException e) {
                optionSelected = -1;
            }
            if (optionSelected <= 0 || optionSelected > menuItems.size()) {
                IOUtil.showMessage("Invalid Option Selected");
            } else {
                return optionSelected;
            }
        }
        throw new InvalidSelectionException();
    }
}
