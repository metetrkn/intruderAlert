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
        System.out.println(getAttackPoint());
        increaseDamage(20.0F);
        System.out.println(getAttackPoint());
    }
}
