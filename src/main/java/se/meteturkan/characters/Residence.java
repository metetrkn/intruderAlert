package se.meteturkan.characters;


public class Residence extends Entity {
    // Player constructor with extra name parameter
    public Residence(String name, float healt, float attackPoint, float defensePoint) {
        super(name, healt, attackPoint, defensePoint);
    }

    // Inside Residence.java
    public void increaseAttack(float points) {
        setAttackPoint(getAttackPoint() + points); // Increases the attack points
        System.out.println(this.getName() + "'s attack has increased by " + points + " points.");
    }


    @Override
    public void specialMove(Entity toPunch) {
        System.out.println("Residence finds his motorcycle helmet on the corner!\n" +
                "His defence increases drastically!\n");
        increaseDefence(15.0F);
    }

    @Override
    public void revertSpecialMove(Entity toPunch) {
        System.out.println("Effects of special move for 'Residence' has ended!\n");
        increaseDefence(-15.0F);
    }
}