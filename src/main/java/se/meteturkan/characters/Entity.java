package se.meteturkan.characters;

import java.util.Random;
import se.meteturkan.common.NumberRound;

public abstract class Entity {
    // Abstract class attributes
    private String name;
    private String role;
    private float health;
    private float attackPoint;
    private float defensePoint;
    private float damage = attackPoint;
    private Random random = new Random(); // Instantiating random object
    private NumberRound round = new NumberRound(); // Instantiating rounder to 2nd decimal

    // Constructor
    public Entity(String name, String role, float health, float attackPoint, float defensePoint) {
        this.name = name;
        this.role = role;
        this.health = health;
        this.attackPoint = attackPoint;
        this.defensePoint = defensePoint;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public float getHealt() {
        return round.roundToTwoDecimals(health);
    }

    public float getAttackPoint() {
        return round.roundToTwoDecimals(damage);
    }

    public float getDefensePoint() {
        return round.roundToTwoDecimals(defensePoint);
    }

    // Attack point setter method
    public void setAttackPoint(float newAmount) {
        this.attackPoint = round.roundToTwoDecimals(newAmount);
    }

    // Defence point setter method
    public void setDefensePoint(float newAmount) {
        this.defensePoint = round.roundToTwoDecimals(newAmount);
    }

    byte specialMoveTurns = 0; // Turn after special moves activated
    boolean keyRevertSpecialMove = false; // Key to activate reversSpecialMove method

    // Method to perform an attack on another entity
    public void punch(Entity toPunch) {
        // Each turn, there is a 20% chance for a special move to occur for both characters
        if (random.nextInt(5) == 1) {
            keyRevertSpecialMove = true; // key to start counting
            specialMove(toPunch);
        }

        // Checks in here if 3 turns happaned
        if (keyRevertSpecialMove) {
            specialMoveTurns++;
        }

        if (specialMoveTurns == 3) {
            revertSpecialMove(toPunch);
            keyRevertSpecialMove = false; // key to stop counting
            specialMoveTurns = 0; // setting special move turns to 0 for next possible usage
        }


        // Calculate base damage
        float baseDamage = this.attackPoint - toPunch.getDefensePoint();

        // Generate a random multiplier between 0.5 and 1.5
        float damageMultiplier = (float) (0.5 + (random.nextFloat())); // random value in [0.5, 1.5]

        // Calculate final damage applying the multiplier
        damage = round.roundToTwoDecimals((float) Math.max(baseDamage * damageMultiplier, 0)); // Ensure damage is non-negative

        // Apply damage to the target entity
        toPunch.takeHit(damage);
        }


    // Method to reduce health when hit
    public void takeHit(float damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0; // Ensure health does not go below zero
        }
    }


    // Method to check if the entity is still conscious
    public boolean isConscious() {
        return this.health > 0;
    }


    // Method to decrease defence of entities
    public void increaseDefence(float change) {
        setDefensePoint(getDefensePoint() + change);
    }

    // Method to increase the attack point of the burglar
    public void increaseDamage(float change) {
        setAttackPoint(getAttackPoint() + change);
    }

    // Special move abstract method, each character will have their own unique move
    public abstract void specialMove(Entity toPunch);

    // Special move revert method, after 3 turn effects disappear
    public abstract void revertSpecialMove(Entity toPunch);
}