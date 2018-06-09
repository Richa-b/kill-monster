package com.rpg.game.menuManager;

import com.rpg.enums.WelcomeMenuType;
import com.rpg.game.entity.Player;
import com.rpg.util.AsciiArt;
import com.rpg.util.IOUtil;

import java.util.Arrays;
import java.util.List;

public class WelcomeMenu implements Menu {


    private void displayOptions(List<WelcomeMenuType> welcomeMenuTypeList) {
        for (WelcomeMenuType aWelcomeMenuTypeList : welcomeMenuTypeList) {
            IOUtil.showMessage(aWelcomeMenuTypeList.ordinal() + 1 + "." + aWelcomeMenuTypeList.getDisplayName());
        }
    }

    @Override
    public Object showMenu(Player player){
        List<WelcomeMenuType> welcomeMenuTypeList = Arrays.asList(WelcomeMenuType.values());
        IOUtil.showMessage("Select an Option to continue!!");
        displayOptions(welcomeMenuTypeList);
        return welcomeMenuTypeList.get(selectOption(welcomeMenuTypeList) - 1);
    }

}
