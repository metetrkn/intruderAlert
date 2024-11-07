package se.meteturkan.rooms;

import se.meteturkan.game.Menu;

import java.util.Scanner;

public class Hall2 extends Room {
    // Constructor
    public Hall2(Scanner scanner, Menu menu) {
        super(scanner); // Pass dependencies to the abstract class constructor
        setRoomName("hall-2");
        //setConnectedRooms();
    }

    private String description = """
                 Hall-2 is slightly wider with brighter lighting.
                 The floor is tiled, and there are a few coat hooks on the wall, some with jackets hanging.
                 A narrow bench sits along one side, and a small window at the end provides natural light.""";


    @Override
    public void getMaterial() {

    }

    public String getDescription() {
        return description;
    }
}
