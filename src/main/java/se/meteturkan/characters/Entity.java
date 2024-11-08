package se.meteturkan.characters;

import java.util.Random;
import se.meteturkan.common.NumberRound;

public abstract class Entity {
    private String name;
    private float health;
    private float attackPoint;
    private float defensePoint;


    // There is random instance in game, send it to here!
    private Random random = new Random(); // Instantiating random object
    private NumberRound round = new NumberRound(); // Instantiating rounder to 2nd decimal
    private byte specialMoveTurns = 0; // Tracks how many turns after special move activates
    private boolean specialMoveActive = false; // If special move is active

    public Entity(String name, float health, float attackPoint, float defensePoint) {
        this.name = name;
        this.health = health;
        this.attackPoint = attackPoint;
        this.defensePoint = defensePoint;
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

        // Calculate base damage
        float baseDamage = this.attackPoint - toPunch.getDefensePoint();

        // Generate a random multiplier between 0.5 and 1.5
        float damageMultiplier = (float) (0.5 + (random.nextFloat())); // random value in [0.5, 1.5]

        // Calculate final damage applying the multiplier
        float damage = round.roundToTwoDecimals((float) Math.max(baseDamage * damageMultiplier, 0)); // Ensure damage is non-negative

        // Apply damage to the target entity
        toPunch.takeHit(damage);

        // Print attack details including damage received by opponent
        System.out.println(this.name + " hits ===> " + toPunch.getName() + " (" + damage + " damage)!");
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
