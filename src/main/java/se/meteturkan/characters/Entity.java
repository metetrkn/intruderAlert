package se.meteturkan.characters;

import java.util.Random;

public abstract class Entity {
    // Abstract class attributes
    private String name;
    private String role;
    private int health;
    private int attackPoint;
    private int defensePoint;
    private int damage;

    // Constructor
    public Entity(String name, String role, int health, int attackPoint, int defensePoint) {
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

    public int getHealt() {
        return health;
    }

    public int getAttackPoint() {
        return damage;
    }

    public int getDefensePoint() {
        return defensePoint;
    }


    // Method to perform an attack on another entity
    public void punch(Entity toPunch) {
        // Calculate base damage
        int baseDamage = this.attackPoint - toPunch.getDefensePoint();

        // Generate a random multiplier between 0.5 and 1.5
        Random random = new Random();
        double damageMultiplier = 0.5 + (random.nextDouble()); // random value in [0.5, 1.5]

        // Calculate final damage applying the multiplier
        damage = (int) Math.max(baseDamage * damageMultiplier, 0); // Ensure damage is non-negative

        // Apply damage to the target entity
        toPunch.takeHit(damage);

        System.out.println("punch method " + damage);
        }

    // Method to reduce health when hit
    public void takeHit(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0; // Ensure health does not go below zero
        }
    }

    // Method to check if the entity is still conscious
    public boolean isConscious() {
        return this.health > 0;
    }

    /**
     * public void setDamage(Material material, int damage) {
     *         Increases damage of residance when fry panna found
     *     }
     */


    // Special move abstract method, each character will have their own unique move
    public abstract void specialMove(Entity toPunch);
}