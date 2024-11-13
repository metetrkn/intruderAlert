package se.meteturkan.characters;

import java.util.Random;

public class Burglar extends Entity {
    // Burglar constructor
    public Burglar(String name, float health, float attackPoint, float defensePoint, Random random) {
        super(name, health, attackPoint, defensePoint, random);
    }

    // Special move: Burglar uses a blinding spray to increase attack power
    @Override
    public void specialMove(Entity toPunch) {
        System.out.println("Bad luck!!! The burglar uses a blinding spray!\n" +
                "The resident is defenseless and burglar's attack increases drastically!\n");
        // Increase burglar's attack by 20 during special move
        increaseDamage(20.0F);
    }

    // Reverting the special move: reducing the attack power back after 3 turns
    @Override
    public void revertSpecialMove(Entity toPunch) {
        System.out.println("Effects of special move for 'Burglar' has ended!\n");
        // Decrease burglar's attack back to normal
        increaseDamage(-20.0F);
    }
}
