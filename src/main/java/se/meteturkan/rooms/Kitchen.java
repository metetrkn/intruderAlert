package se.meteturkan.rooms;

import se.meteturkan.common.OptionController;
import se.meteturkan.game.Menu;
import java.util.Scanner;

public class Kitchen extends Room {
    // Constructor
    public Kitchen(Scanner scanner, Menu menu, OptionController controller) {
        super(scanner, menu, controller); // Pass dependencies to the abstract class constructor
        setRoomName("kitchen");
    }

    private String description = """
            The kitchen is compact but functional, with counters cluttered with utensils and cooking tools.
            A stove, fridge, and sink are neatly arranged along one wall. 
            The floor is tiled, and a small window overlooks the backyard. 
            A few dishes are stacked in the sink, and the faint smell of food lingers in the air.""";


    @Override
    public void getMaterial() {
        System.out.println("\nYou see a frying pan on the stove.\n\nYou decide to\n 1- Take it!\n 2- Do not touch!\n\n");
        int choice = controller.checker(1,2); // User choice to take material or leave it

        if (choice == 1){
            menu.printStringWithDelay("You took the frying pan. Your attack skills increased by 17 points!", 10);
            // Function to increase attack skills
        }
    }

    public String getDescription() {
        return description;
    }
}
