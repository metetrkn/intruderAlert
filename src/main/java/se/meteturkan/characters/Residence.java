package se.meteturkan.characters;


public class Residence extends Entity {
    // Player constructor with extra name parameter
    public Residence(String name, String role, float healt, float attackPoint, float defensePoint) {
        super(name, role, healt, attackPoint, defensePoint);
    }

    @Override
    public void specialMove(Entity toPunch) {
        System.out.println("Residence finds his motorcycle helmet on the corner!\n" +
                "His defence increases drastically!");
        increaseDefence(20.0F);
    }

    @Override
    public void revertSpecialMove(Entity toPunch) {
        System.out.println("Effects of special move for 'Residence' has ended!");
        increaseDefence(-20.0F);
    }
}