package com.rpg.game;

import com.rpg.enums.WelcomeMenuType;
import com.rpg.game.entity.Character;
import com.rpg.game.entity.Player;
import com.rpg.game.menuManager.Menu;
import com.rpg.game.menuManager.WelcomeMenu;
import com.rpg.util.AsciiArt;
import com.rpg.util.IOUtil;

import static com.rpg.enums.WelcomeMenuType.EXIT;
import static com.rpg.game.entity.Monster.createDefaultMonster;

public class GameManager {

    private final Character player;
    private final Character monster;

    public GameManager(Character player, Character monster) {
        this.player = player;
        this.monster = monster;
    }

    public static void launchGame() throws Exception {
        Menu menu = new WelcomeMenu();
        WelcomeMenuType welcomeMenuType;
        IOUtil.showMessage(AsciiArt.WELCOME_MESSAGE);
        do {
            welcomeMenuType = (WelcomeMenuType) menu.showMenu(null);
            switch (welcomeMenuType) {
                case START:
                    createGame();
                    break;
                case EXIT:
                    exitGame();
                    break;
                default:
                    throw new Exception("Something Unusual Happened!!!");
            }
        } while (EXIT != welcomeMenuType);
    }

    public static void createGame() {

        GameManager game = new GameManager(createPlayer(), createMonster());
        //game.welcomePlayerAndShowPowerStats();
        game.startGame();
    }

    public void startGame() {
        ActionManager actionManager = new ActionManager(player, monster);
        actionManager.performOperation();
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
