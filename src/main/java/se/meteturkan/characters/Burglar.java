package se.meteturkan.characters;

import java.util.Random;

public class Burglar extends Entity {
    // Burglar constructor
    public Burglar(String name, float health, float attackPoint, float defensePoint, Random random) {
        super(name, health, attackPoint, defensePoint, random);
    }

    @Override
    public void specialMove(Entity toPunch) {
        System.out.println("Bad luck!!! The burglar uses a blinding spray!\n" +
                "The resident is defenseless and burglar's attack increases drastically!\n");
        increaseDamage(20.0F);
    }


    @Override
    public void revertSpecialMove(Entity toPunch) {
        System.out.println("Effects of special move for 'Burglar' has ended!\n");
        increaseDamage(-20.0F);
    }
}
