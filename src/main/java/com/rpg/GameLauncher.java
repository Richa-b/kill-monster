package com.rpg;

import com.rpg.exception.InvalidSelectionException;
import com.rpg.game.Menu;
import com.rpg.game.WelcomeMenu;

public class GameLauncher {

    public static void main(String[] args) throws Exception {
        try {
            Menu menu = new WelcomeMenu();
            menu.showMenu();
        } catch (InvalidSelectionException exception) {
            System.exit(1);
        }
    }

}
