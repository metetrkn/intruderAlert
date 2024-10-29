package se.meteturkan.adventure.model;


public class Burglar extends Character{
    public Burglar(String role, float HP, float DP, float AP) {
        super(role, HP, DP, AP);
    }

    @Override
    public void specialAbility() {
        System.out.println("The burglar can be unseen and dodge attack for 2 turn.");
    }
}