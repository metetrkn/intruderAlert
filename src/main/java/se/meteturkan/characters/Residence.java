package se.meteturkan.characters;


public class Residence extends Entity {
    // Player constructor with extra name parameter
    public Residence(String name, String role, int healt, int attackPoint, int defensePoint) {
        super(name, role, healt, attackPoint, defensePoint);
    }

    @Override
    public void specialMove(Entity toPunch) {
        System.out.println("Implemenations!");
    }



}