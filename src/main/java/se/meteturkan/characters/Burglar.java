package se.meteturkan.characters;

public class Burglar extends Entity {
    // Burglar constructor
    public Burglar(String name, String role, float health, float attackPoint, float defensePoint) {
        super(name, role, health, attackPoint, defensePoint);
    }

    @Override
    public void specialMove(Entity toPunch) {
        System.out.println("Bad luck!!! The burglar uses a blinding spray!\n" +
                "The resident is defenseless and burglar's attack increases drastically!");
        increaseDamage(20.0F);
    }

    @Override
    public void revertSpecialMove(Entity toPunch) {
        System.out.println("Effects of special move for 'Burglar' has ended!");
        increaseDamage(-20.0F);
    }
}
