package com.mygdx.game.model;

/**
 * Created by martinso on 20/04/16.
 */
public class Armor implements IItem {

    private String type;
    private String name;
    private int bonusHealth;

    public Armor(String name, String type, int bonusHealth) {
        this.type = type;
        this.name = name;
        this.bonusHealth = bonusHealth;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getStats() {
        return bonusHealth;
    }

    public void setStats(int bonusHealth) {
        this.bonusHealth = bonusHealth;
    }
}
