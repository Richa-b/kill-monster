package com.rpg.game;

import java.util.ArrayList;
import java.util.List;


public class Player {

    private String name;
    private Integer lives = 100;
    private Integer coins=0;
    private String description;
    private List<Weapon> weaponList = new ArrayList<>();

    public Player(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Hello " + name + ". Welcome!!!! You have" +
                "\n"+ lives + " lives." +
                "\n"+ coins + " coins." +
                "\n"+ (weaponList.size()>0?"You have weapons" :"OOPS!! " +
                "You have no weapons for now" );
    }

    public static PlayerBuilder builder() {
        return new PlayerBuilder();
    }

    public static class PlayerBuilder {

        private String name;
        private String description;

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public PlayerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Player build() {
            return new Player(this.name, this.description);
        }
    }
}
