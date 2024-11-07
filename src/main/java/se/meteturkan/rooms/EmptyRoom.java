package se.meteturkan.rooms;

import se.meteturkan.game.Menu;

import java.util.Scanner;

public class EmptyRoom extends Room {
    // Constructor
    public EmptyRoom(Scanner scanner, Menu menu) {
        super(scanner); // Pass dependencies to the abstract class constructor
        setRoomName("empty room");
        //setConnectedRooms();
    }

    private String description = """
                      The empty room is bare and quiet. The walls are plain, and the floor is covered in dust.
                      A single window lets in a faint light, casting shadows across the empty space.
                      There is no furniture, just an empty, echoing space.""";

    @Override
    public void getMaterial() {

    }

    public String getDescription() {
        return description;
    }
}
