package se.meteturkan.rooms;

import java.util.HashMap;

public class Materials {
    HashMap<String, Integer> material = new HashMap<>(); // Material map key=name, value=hit point

    public void addMaterials() {
        material.put("Frying pan", 15);
        material.put("Scissor", 15);
    }
}
