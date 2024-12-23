package se.meteturkan.characters;

import java.util.Random;
import se.meteturkan.common.NumberRound;

public abstract class Entity {
    private String name;
    private float health;
    private float attackPoint;
    private float defensePoint;
    private Random random; // dependency injection, random object instantiated in game class and sent here
    private NumberRound round = new NumberRound(); // Instantiating rounder to 2nd decimal
    private byte specialMoveTurns = 0; // Tracks how many turns after special move activates
    private boolean specialMoveActive = false; // If special move is active

    public Entity(String name, float health, float attackPoint, float defensePoint, Random random) {
        this.name = name;
        this.health = health;
        this.attackPoint = attackPoint;
        this.defensePoint = defensePoint;
        this.random = random;
    }

    public String getName() {
        return name;
    }

    public float getHealt() {
        return round.roundToTwoDecimals(health);
    }

    public float getAttackPoint() {
        return round.roundToTwoDecimals(attackPoint);
    }

    public float getDefensePoint() {
        return round.roundToTwoDecimals(defensePoint);
    }

    public void setAttackPoint(float newAmount) {
        this.attackPoint = round.roundToTwoDecimals(newAmount);
    }

    public void setDefensePoint(float newAmount) {
        this.defensePoint = round.roundToTwoDecimals(newAmount);
    }


    // Method to perform an attack on another entity
    public void punch(Entity toPunch) {
        if (!specialMoveActive && random.nextInt(4) == 0) {
            specialMoveActive = true;
            specialMove(toPunch);
        }

        if (specialMoveActive) {
            specialMoveTurns++;
            if (specialMoveTurns == 3) {
                revertSpecialMove(toPunch);
                specialMoveActive = false;
                specialMoveTurns = 0;
            }
        }

        // Calculate and apply damage
        float damage = calculateDamage(toPunch);
        toPunch.takeHit(damage);

        // Print attack details including damage received by opponent
        System.out.println(this.name + " hits ===> " + toPunch.getName() + " (" + damage + " damage)!");
    }


    // Helper method to calculate damage
    private float calculateDamage(Entity toPunch) {
        float baseDamage = this.attackPoint - toPunch.getDefensePoint();
        float damageMultiplier = 0.5f + random.nextFloat(); // random value in [0.5, 1.5]
        return round.roundToTwoDecimals(Math.max(baseDamage * damageMultiplier, 0)); // Ensure damage is non-negative
    }


    public void takeHit(float damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0; // Ensure health does not go below zero
        }
    }

    public boolean isConscious() {
        return this.health > 0;
    }

    public void increaseDefence(float change) {
        setDefensePoint(getDefensePoint() + change);
    }

    public void increaseDamage(float change) {
        setAttackPoint(getAttackPoint() + change);
    }

    // Abstract methods
    public abstract void specialMove(Entity toPunch);

    public abstract void revertSpecialMove(Entity toPunch);
}
