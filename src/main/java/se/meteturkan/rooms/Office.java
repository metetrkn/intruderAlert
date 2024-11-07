package se.meteturkan.rooms;

import se.meteturkan.common.OptionController;
import se.meteturkan.game.Menu;

import java.util.Scanner;

public class Office extends Room {
    // Constructor
    public Office(Scanner scanner, Menu menu, OptionController controller) {
        super(scanner, menu, controller); // Pass dependencies to the abstract class constructor
        setRoomName("office");
    }

    private String description = """
                      The office is compact and orderly. A wooden desk sits against the wall,
                      topped with a computer and neatly stacked papers. A comfortable chair is
                      positioned behind the desk, and a small bookshelf filled with books and
                      files stands in the corner. The window allows natural light to flood the room,
                      brightening the space. Simple wall art adds a touch of personality, while a potted
                      plant brings a bit of nature indoors. The overall atmosphere is calm and professional.""";

    @Override
    public boolean getMaterial() {
        System.out.println("\nYou see the mobile phone on the corner.\n\nYou decide to\n 1- Call the police!\n 2- Hide the body of burglar!\n\n");
        int choice = controller.checker(1,2); // User choice to take material or leave it

        // If user chooses to call the police
        if (choice == 1){
            menu.printStringWithDelay("You took the phone and call the police!\n" +
                    "<1000 minutes later> Based on sirens they are close. Nightmare ends!\n" +
                    "Thanks for playing!", 10);

            menu.farewell(); // Farewell message before game ends
            System.exit(0); // The game closes
            return true;
        } else { // If user do not call police, can continue travel through house
            menu.printStringWithDelay("You have choosen a dark path!\n" +
                    "But it is not this games problem.\n" +
                    "You can just continue to travel through house", 10);
        }
        return false;
    }

    public String getDescription() {
        return description;
    }
}
