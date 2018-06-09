package com.rpg.game;

import com.rpg.util.AsciiArt;
import com.rpg.util.IOUtil;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    public Player.PlayerBuilder showWelcomeMenu() {
        IOUtil.showMessage(AsciiArt.WELCOME_MESSAGE);
        IOUtil.showMessage("What is your Name????");
        String name = IOUtil.getStringInput();
        IOUtil.showMessage("A Little Description about yourself????");
        String description = IOUtil.getStringInput();
        return Player.builder()
                .setName(name)
                .setDescription(description);
    }

}
