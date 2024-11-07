package se.meteturkan.rooms;

import se.meteturkan.common.OptionController;
import se.meteturkan.game.Menu;

import java.util.Scanner;

public class Bedroom extends Room {
    // Constructor
    public Bedroom(Scanner scanner, Menu menu, OptionController controller) {
        super(scanner, menu, controller); // Pass dependencies to the abstract class constructor
        setRoomName("bedroom");
        //setConnectedRooms();
    }

    private String description = """
                   The bedroom is cozy with a large bed covered in a thick quilt.
                   There's a wooden dresser with a few clothes scattered on top.
                   A small nightstand beside the bed holds a lamp and a book.
                   The floor is carpeted, and a window with curtains lets in some light. 
                   A closet door is slightly ajar, revealing hanging clothes.""";

    @Override
    public void getMaterial() {
        System.out.println();
    }

    public String getDescription() {
        return description;
    }
}
