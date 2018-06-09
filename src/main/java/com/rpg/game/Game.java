package com.rpg.game;

import com.rpg.enums.WeaponType;
import com.rpg.game.entity.Character;
import com.rpg.game.entity.Player;
import com.rpg.util.IOUtil;

import static com.rpg.game.entity.Monster.createDefaultMonster;

public class Game {

    private final Character player;
    private final Character monster;

    public Game(Character player, Character monster) {
        this.player = player;
        this.monster = monster;
    }

    public static void createGame() throws Exception {

        Game game = new Game(createPlayer(), createMonster());
        game.welcomePlayerAndShowPowerStats();
        game.startGame();
    }

    public void startGame() throws Exception {
        Fight fight = new Fight(player, monster);
        fight.startFighting();
    }

    public static void resumeGame() {

    }

    public static void exitGame() {
        IOUtil.showMessage("B Byeee.. See you");
        System.exit(0);
    }

    public static void endGame() {
        IOUtil.showMessage("You have died.. Game Over");
        System.exit(0);
    }

    public static void saveGame() {

    }

    private void welcomePlayerAndShowPowerStats() {
        IOUtil.showMessage(player.toString());
    }

    private static Character createPlayer() {

        IOUtil.showMessage("What is your Name????");
        String name = IOUtil.getStringInput();
        IOUtil.showMessage("A Little Description about yourself????");
        String description = IOUtil.getStringInput();
        Player.PlayerBuilder playerBuilder = Player.builder()
                .setName(name)
                .setDescription(description);
        return playerBuilder.build();
    }

    private static Character createMonster() {
        return createDefaultMonster();
    }
}
