package se.meteturkan.characters;


public abstract class Entity {
    // Abstract class attributes
    private String name;
    private String role;
    private int health;
    private int attackPoint;
    private int defensePoint;

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
        return attackPoint;
    }

    public int getDefensePoint() {
        return defensePoint;
    }



    // Method to perform an attack on another entity
    public void punch(Entity toPunch) {
        int damage = this.attackPoint - toPunch.getDefensePoint();
        if (damage > 0) {
            toPunch.takeHit(damage);
        } else {
            toPunch.takeHit(0); // No damage if attack is less than or equal to defense
        }
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
     * public void increaseDamage(Material material, int damage) {
     *         Increases damage of players when material in rooms found
     *     }
     */


    // Special move abstract method, each character will have their own unique move
    public abstract void specialMove(Entity toPunch);
}