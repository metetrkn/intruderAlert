package se.meteturkan.rooms;

import se.meteturkan.game.Menu;

import java.util.Scanner;

public class Bathroom extends Room {
    // Constructor
    public Bathroom(Scanner scanner, Menu menu) {
        super(scanner); // Pass dependencies to the abstract class constructor
        setRoomName("bathroom");
        //setConnectedRooms();
    }

    private String description = """
            The bathroom is small with white tiles and a faint smell of mildew. 
            There's a sink with a mirror above it and a bathtub with a shower curtain.'
            The floor has a damp bath mat, and a small window lets in some light.
            A cabinet holds a few towels, and a dripping toilet sits in the corner.""";

    @Override
    public void getMaterial() {

    }

    public String getDescription() {
        return description;
    }
}
