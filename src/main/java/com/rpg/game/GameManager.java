package com.rpg.game;

import com.rpg.enums.WelcomeMenuType;
import com.rpg.game.entity.Character;
import com.rpg.game.entity.Game;
import com.rpg.game.entity.Player;
import com.rpg.game.menuManager.Menu;
import com.rpg.game.menuManager.WelcomeMenu;
import com.rpg.io.SerializationProvider;
import com.rpg.util.AsciiArt;
import com.rpg.util.IOUtil;

import static com.rpg.enums.WelcomeMenuType.EXIT;
import static com.rpg.game.entity.Monster.createDefaultMonster;

public class GameManager {

    private final Game game;

    public GameManager(Game game) {
        this.game = game;
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
                case RELOAD:
                    resumeGame();
                case EXIT:
                    exitGame();
                    break;
                default:
                    throw new Exception("Something Unusual Happened!!!");
            }
        } while (EXIT != welcomeMenuType);
    }

    public static void createGame() {

        GameManager gameManager = new GameManager(new Game(createPlayer(), createMonster()));
        gameManager.startGame();
    }

    public void startGame() {
        ActionManager actionManager = new ActionManager(game);
        actionManager.performOperation();
    }

    public static void resumeGame() {
        SerializationProvider<Game> serializationProvider = new SerializationProvider<>();
        GameManager gameManager = new GameManager(serializationProvider.deSerializeObject());
        gameManager.startGame();
    }

    public static void exitGame() {
        IOUtil.showMessage("B Byeee.. See you");
        System.exit(0);
    }

    public static void endGame() {
        IOUtil.showMessage("You have died.. Game Over");
        System.exit(0);
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
