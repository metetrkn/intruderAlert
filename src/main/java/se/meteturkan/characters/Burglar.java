package se.meteturkan.characters;

public class Burglar extends Entity {
    // Burglar constructor
    public Burglar(String name, String role, int healt, int attackPoint, int defensePoint){
        super(name, role, healt, attackPoint, defensePoint);
    }

    @Override
    public void specialMove(Entity toPunch) {
        System.out.println("implementations");
    }


}
