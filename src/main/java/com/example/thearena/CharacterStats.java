package com.example.thearena;

/**
 * CharacterStats Class
 * */
public class CharacterStats {

    private String race;
    private String job;

    private int baseHP;
    private int baseAttack;
    private int baseDefense;
    private int baseAgility;
    private int baseMagicAttack;
    private int baseMagicDefense;

    /**
     * Class Constructor
     * */
    public CharacterStats() {}

    /**
     * Class constructor setting base character stats
     * */
    public CharacterStats(int baseHP, int baseAttack, int baseDefense, int baseAgility, int baseMagicAttack, int baseMagicDefense) {
        this.baseHP = baseHP;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.baseAgility = baseAgility;
        this.baseMagicAttack = baseMagicAttack;
        this.baseMagicDefense = baseMagicDefense;
    }

    public int getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public int getBaseAgility() {
        return baseAgility;
    }

    public void setBaseAgility(int baseAgility) {
        this.baseAgility = baseAgility;
    }

    public int getBaseMagicAttack() {
        return baseMagicAttack;
    }

    public void setBaseMagicAttack(int baseMagicAttack) {
        this.baseMagicAttack = baseMagicAttack;
    }

    public int getBaseMagicDefense() {
        return baseMagicDefense;
    }

    public void setBaseMagicDefense(int baseMagicDefense) {
        this.baseMagicDefense = baseMagicDefense;
    }
}
