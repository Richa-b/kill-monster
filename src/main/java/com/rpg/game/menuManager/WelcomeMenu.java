package com.rpg.game.menuManager;

import com.rpg.game.Game;
import com.rpg.game.WelcomeMenuType;
import com.rpg.game.entity.Player;
import com.rpg.game.menuManager.Menu;
import com.rpg.util.AsciiArt;
import com.rpg.util.IOUtil;

import java.util.Arrays;
import java.util.List;

import static com.rpg.game.WelcomeMenuType.EXIT;

public class WelcomeMenu implements Menu {


    private void displayOptions(List<WelcomeMenuType> welcomeMenuTypeList) {
        for (WelcomeMenuType aWelcomeMenuTypeList : welcomeMenuTypeList) {
            IOUtil.showMessage(aWelcomeMenuTypeList.ordinal() + 1 + "." + aWelcomeMenuTypeList.getDisplayName());
        }
    }


    @Override
    public Object showMenu(Player player) throws Exception {
        List<WelcomeMenuType> welcomeMenuTypeList = Arrays.asList(WelcomeMenuType.values());
        WelcomeMenuType welcomeMenuTypeSelection;
        IOUtil.showMessage(AsciiArt.WELCOME_MESSAGE);
        do {
            displayOptions(welcomeMenuTypeList);
            welcomeMenuTypeSelection = welcomeMenuTypeList.get(selectOption(welcomeMenuTypeList) - 1);
            switch (welcomeMenuTypeSelection) {
                case START:
                    Game.createGame();
                    break;
                case EXIT:
                    Game.exitGame();
                    break;
                default:
                    throw new Exception("Something Unusual Happened!!!");
            }
        } while (EXIT != welcomeMenuTypeSelection);
        return welcomeMenuTypeSelection;
    }

}
