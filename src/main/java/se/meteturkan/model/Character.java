package se.meteturkan.adventure.model;


public abstract class Character {
    private String role; // Player's name
    private float HP; // Player's Health Point
    private float DP; // Player's Defense Point
    private float AP; // Player's Attack Point


    // Constructor
    public Character(String role, float HP, float DP, float AP) {
        this.role = role;
        this.HP = HP;
        this.DP = DP;
        this.AP = AP;
    }


    // Concrete Getters
    public String getRole() {
        return role;
    }

    public float getHP() {
        return HP;
    }

    public float getDP() {
        return DP;
    }

    public float getAP() {
        return AP;
    }


    // Set method to increase characters attack point
    public void setAP(float AP) {
        this.AP += AP;
    }

    // Increasing attack point when characters find a material
    public void setDamage(float damage) {
        setAP(damage);
    }


    // Decreasing health point when character attacked
    public void takeDamage(float damage) {
        this.HP -= damage; // Corrected to use the damage parameter
    }

    // Attack method, creates damage on attacked character
    public void attack(Character attacked) {
        attacked.takeDamage(getAP());
    }


    // Returns if characters health is bigger than 0
    public boolean isAlive() {
        return getHP() > 0;
    }

    // Abstract method for subclasses to implement their own special ability
    public abstract void specialAbility();
}