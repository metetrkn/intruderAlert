package se.meteturkan.rooms;

import se.meteturkan.common.OptionController;
import se.meteturkan.game.Menu;

import java.util.Scanner;

public class Bathroom extends Room {
    // Constructor
    public Bathroom(Scanner scanner, Menu menu, OptionController controller) {
        super(scanner, menu, controller); // Pass dependencies to the abstract class constructor
        setRoomName("bathroom");
    }

    private String description = """
            The bathroom is small with white tiles and a faint smell of mildew. 
            There's a sink with a mirror above it and a bathtub with a shower curtain.'
            The floor has a damp bath mat, and a small window lets in some light.
            A cabinet holds a few towels, and a dripping toilet sits in the corner.""";

    @Override
    public boolean getMaterial() {
        System.out.println("\nYou see a scissor in the shelf.\n\nYou decide to\n 1- Take it!\n 2- Do not touch!\n\n");
        int choice = controller.checker(1,2); // User choice to take material or leave it

        // If user takes material, returns true, otherwise false
        if (choice == 1){
            menu.printStringWithDelay("You took the scissor.", 10);
            return true;
        }
        return false;
    }

    public String getDescription() {
        return description;
    }
}
