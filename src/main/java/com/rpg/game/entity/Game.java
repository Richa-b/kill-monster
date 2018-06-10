package com.rpg.game.entity;

import java.io.Serializable;

public class Game implements Serializable {

    private Character player;
    private Character monster;

    public Game(Character player, Character monster) {
        this.player = player;
        this.monster = monster;
    }

    public Character getPlayer() {
        return player;
    }

    public void setPlayer(Character player) {
        this.player = player;
    }

    public Character getMonster() {
        return monster;
    }

    public void setMonster(Character monster) {
        this.monster = monster;
    }

}
