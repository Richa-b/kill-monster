package com.rpg.game;

import com.rpg.util.IOUtil;

public class Game {

    private final Player player;

    public Game(Player player) {
        this.player = player;
    }

    public static void createGame() throws Exception {

        Game game = new Game(createPlayer());
        game.welcomePlayerAndShowPowerStats();
        startGame();
    }

    public static void startGame() {

    }

    public static void resumeGame() {

    }

    public static void exitGame() {
        IOUtil.showMessage("B Byeee.. See you");
        System.exit(0);
    }

    public static void saveGame() {

    }

    private void welcomePlayerAndShowPowerStats() {
        IOUtil.showMessage(player.toString());
    }

    private static Player createPlayer() {

        IOUtil.showMessage("What is your Name????");
        String name = IOUtil.getStringInput();
        IOUtil.showMessage("A Little Description about yourself????");
        String description = IOUtil.getStringInput();
        Player.PlayerBuilder playerBuilder = Player.builder()
                .setName(name)
                .setDescription(description);
        return playerBuilder.build();
    }
}
