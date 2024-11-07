package se.meteturkan.rooms;


import se.meteturkan.game.Menu;

import java.util.Scanner;

public class Kitchen extends Room {
    Scanner scanner;

    Materials materials;
    // Constructor
    public Kitchen(Scanner scanner, Menu menu) {
        super(scanner); // Pass dependencies to the abstract class constructor
        setRoomName("kitchen");
        //setConnectedRooms();
    }

    private String description = """
            The kitchen is compact but functional, with counters cluttered with utensils and cooking tools.
            A stove, fridge, and sink are neatly arranged along one wall. 
            The floor is tiled, and a small window overlooks the backyard. 
            A few dishes are stacked in the sink, and the faint smell of food lingers in the air.""";


    @Override
    public void getMaterial() {
        System.out.println("\nYou see frying pan on the stove.\nYou decide to\n 1- Take it!\n 2- Do not touch!");
        int choice = scanner.nextInt();
        // OptionController = ....
        materials.material.get("Frying pan");
    }

    public String getDescription() {
        return description;
    }
}
