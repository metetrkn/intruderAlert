package se.meteturkan.characters;


import java.util.Random;

public class Residence extends Entity {
    // Player constructor with extra name parameter
    public Residence(String name, float healt, float attackPoint, float defensePoint, Random random) {
        super(name, healt, attackPoint, defensePoint, random);
    }

    // Increase attack method
    public void increaseAttack(float points) {
        setAttackPoint(getAttackPoint() + points); // Increases the attack points
        System.out.println(this.getName() + "'s attack has increased by " + points + " points.");
    }


    // Special move: Residence uses the motorcycle helmet to increase defense
    @Override
    public void specialMove(Entity toPunch) {
        System.out.println("Residence finds his motorcycle helmet on the corner!\n" +
                "His defense increases drastically!\n");
        increaseDefence(15.0F); // Increase defense by 15
    }

    // Reverting special move: Restore defense to normal
    @Override
    public void revertSpecialMove(Entity toPunch) {
        System.out.println("Effects of special move for 'Residence' have ended!\n");
        increaseDefence(-15.0F); // Decrease defense back to original value
    }
}