package com.rpg.game.entity;

import com.rpg.enums.WeaponType;
import com.rpg.util.KillMonsterConstants;


public class Player extends Character {

    private Integer coins = 0;
    private Integer level = 1;


    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Integer getCoins() {
        return coins;
    }


    private Player(String name, String description) {
        this.name = name;
        this.description = description;
        this.hp = KillMonsterConstants.DEFAULT_PLAYER_HP;
        createDefaultWeaponListForPlayer();
    }

    private void createDefaultWeaponListForPlayer() {
        weaponList.add(new Weapon(WeaponType.GUN, KillMonsterConstants.DEFAULT_PLAYER_GUN_COUNT));
        weaponList.add(new Weapon(WeaponType.ARROW, KillMonsterConstants.DEFAULT_PLAYER_ARROW_COUNT));
        weaponList.add(new Weapon(WeaponType.KNIFE, KillMonsterConstants.DEFAULT_PLAYER_KNIFE_COUNT));
    }

    /*@Override
    public String toString() {
        return "Hello " + name + ". Welcome!!!! You have" +
                "\n" + hp + " hp." +
                "\n" + coins + " coins." +
                "\n" + (weaponList.size() > 0 ? "You have weapons" : "OOPS!! " +
                "You have no weapons for now");
    }
*/
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
        coins = coins + (int) (Math.random() * this.getHp() + 1);
    }

    public void decrementCoins(WeaponType weaponType) {
        coins = coins - weaponType.getCoinsPerWeapon();
    }

    public void levelUp() {
        level++;
        hp = 100;
    }
}
