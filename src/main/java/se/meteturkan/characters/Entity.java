package se.meteturkan.characters;

import java.util.Random;

public abstract class Entity {
    // Abstract class attributes
    private String name;
    private String role;
    private float health;
    private float attackPoint;
    private float defensePoint;
    private float damage;
    private Random random = new Random(); // Instantiating random object

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

    public String getRole() {
        return role;
    }

    public float getHealt() {
        return health;
    }

    public float getAttackPoint() {
        return attackPoint;
    }

    public float getDefensePoint() {
        return defensePoint;
    }

    // Attack point setter method
    public void setAttackPoint(float newAmount) {
        this.attackPoint = newAmount;
    }

    // Method to perform an attack on another entity
    public void punch(Entity toPunch) {
        // Each turn, there is a 20% chance for a special move to occur for both characters
        int specialMoveChance  = random.nextInt(5);

            if (specialMoveChance  == 1) {
                specialMove(toPunch);
            }

        // Calculate base damage
        float baseDamage = this.attackPoint - toPunch.getDefensePoint();

        // Generate a random multiplier between 0.5 and 1.5
        double damageMultiplier = 0.5 + (random.nextDouble()); // random value in [0.5, 1.5]

        // Calculate final damage applying the multiplier
        damage = (float) Math.max(baseDamage * damageMultiplier, 0); // Ensure damage is non-negative

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



    // Special move abstract method, each character will have their own unique move
    public abstract void specialMove(Entity toPunch);
}