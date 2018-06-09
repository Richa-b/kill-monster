package com.rpg.game;

import com.rpg.exception.InvalidSelectionException;
import com.rpg.util.AsciiArt;
import com.rpg.util.IOUtil;

import java.util.InputMismatchException;

import static com.rpg.game.WelcomeMenuType.EXIT;

public class WelcomeMenu implements Menu {


    private void displayOptions(WelcomeMenuType[] welcomeMenuTypeList) {
        for (WelcomeMenuType aWelcomeMenuTypeList : welcomeMenuTypeList) {
            IOUtil.showMessage(aWelcomeMenuTypeList.ordinal() + 1 + "." + aWelcomeMenuTypeList.getDisplayName());
        }
    }

    @Override
    public void showMenu() throws Exception {
        WelcomeMenuType[] welcomeMenuTypeList = WelcomeMenuType.values();
        WelcomeMenuType welcomeMenuTypeSelection;
        IOUtil.showMessage(AsciiArt.WELCOME_MESSAGE);
        do {
            displayOptions(welcomeMenuTypeList);
            welcomeMenuTypeSelection = welcomeMenuTypeList[selectOption()-1];
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
    }

    @Override
    public Integer selectOption() {
        int optionSelected;
        for (int i = 0; i < 5; i++) {
            try {
                optionSelected = IOUtil.getIntegerInput();
            } catch (InputMismatchException e) {
                optionSelected = -1;
            }
            if (optionSelected <= 0 || optionSelected > WelcomeMenuType.values().length) {
                IOUtil.showMessage("Invalid Option Selected");
            } else {
                return optionSelected;
            }
        }
        throw new InvalidSelectionException();
    }


}
