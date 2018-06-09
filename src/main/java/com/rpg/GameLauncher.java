package com.rpg;

import com.rpg.exception.InvalidSelectionException;
import com.rpg.game.GameManager;

public class GameLauncher {

    public static void main(String[] args) throws Exception {
        try {
            GameManager.launchGame();
        } catch (InvalidSelectionException exception) {
            System.exit(1);
        }
    }

}
