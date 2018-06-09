package com.rpg.game.menuManager;

import com.rpg.enums.ActionType;
import com.rpg.game.entity.Player;
import com.rpg.util.IOUtil;

import java.util.Arrays;
import java.util.List;

public class ActionMenu implements Menu {
    
    @Override
    public Object showMenu(Player player) {
        List<ActionType> actionTypes = Arrays.asList(ActionType.values());
        IOUtil.showMessage("What do you want to do?????");
        displayOptions(actionTypes);
        return actionTypes.get(selectOption(actionTypes) - 1);
    }

    private void displayOptions(List<ActionType> actionTypes) {
        ActionType actionType;
        for (int i = 0; i < actionTypes.size(); i++) {
            actionType = actionTypes.get(i);
            IOUtil.showMessage((i + 1) + "." + actionType.getDisplayName());
        }
    }
}
