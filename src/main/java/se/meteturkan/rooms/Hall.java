package se.meteturkan.rooms;

import se.meteturkan.game.Menu;
import java.util.Scanner;

public class Hall extends Room {
    private Menu menu;

    // Constructor
    public Hall(Scanner scanner, Menu menu) {
        super(scanner, menu); // Pass dependencies to the abstract class constructor
        setRoomName("hall");
        //setConnectedRooms();
    }

    private String description = """
            Hall
            """;

    @Override
    public void describeRoom() {  // Printing out room description with 10 millisecond delays
        menu.printStringWithDelay(description, 10);
    }

    @Override
    public void getMaterial() {

    }
}
