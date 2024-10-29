package se.meteturkan.adventure.model;


public class Residence extends Character {
    public Residence(String role, float HP, float DP, float AP) {
        super(role, HP, DP, AP);
    }

    @Override
    public void specialAbility() {
        System.out.println("Gain a temporary boost to defense or attack when " +
                "fighting in familiar surroundings (e.g., home turf)." +
                "Defence point increases for one or 2 turn");
    }
}

