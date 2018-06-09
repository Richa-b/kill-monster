package com.rpg.game.entity;

import com.rpg.enums.WeaponType;
import com.rpg.game.Weapon;
import com.rpg.util.KillMonsterConstants;


public class Player extends Character {

    private Integer coins = 0;

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Integer getCoins() {
        return coins;
    }


    private Player(String name, String description) {
        this.name = name;
        this.description = description;
        this.lives = KillMonsterConstants.DEFAULT_PLAYER_LIVES;
        createDefaultWeaponListForPlayer();
    }

    private void createDefaultWeaponListForPlayer() {
        weaponList.add(new Weapon(WeaponType.GUN, KillMonsterConstants.DEFAULT_PLAYER_GUN_COUNT));
        weaponList.add(new Weapon(WeaponType.ARROW, KillMonsterConstants.DEFAULT_PLAYER_ARROW_COUNT));
        weaponList.add(new Weapon(WeaponType.KNIFE, KillMonsterConstants.DEFAULT_PLAYER_KNIFE_COUNT));
    }

    @Override
    public String toString() {
        return "Hello " + name + ". Welcome!!!! You have" +
                "\n" + lives + " lives." +
                "\n" + coins + " coins." +
                "\n" + (weaponList.size() > 0 ? "You have weapons" : "OOPS!! " +
                "You have no weapons for now");
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

        public Player buildDefault() {
            return new Player(this.name, this.description);
        }

    }

    public void receiveCoins() {
        coins = coins + (int) (Math.random() * this.getLives() + 1);
    }
}
