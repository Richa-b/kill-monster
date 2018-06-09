package com.rpg;

import com.rpg.game.Menu;
import com.rpg.game.Player;
import com.rpg.util.IOUtil;

public class GameLauncher {


    public static void main(String[] args) {
        GameLauncher gameLauncher = new GameLauncher();
        Menu welcomeMenu = new Menu();
        IOUtil.showMessage
                (gameLauncher.createPlayer(welcomeMenu.showWelcomeMenu()).toString());

    }

    Player createPlayer(Player.PlayerBuilder playerBuilder) {
        return playerBuilder.build();
    }
}
