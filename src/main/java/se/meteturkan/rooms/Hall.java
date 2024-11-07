package se.meteturkan.rooms;


import se.meteturkan.common.OptionController;
import se.meteturkan.game.Menu;

import java.util.Scanner;

public class Hall extends Room {
    // Constructor
    public Hall(Scanner scanner, Menu menu, OptionController controller) {
        super(scanner, menu, controller); // Pass dependencies to the abstract class constructor
        setRoomName("hall");
        //setConnectedRooms();
    }

    private String description = """
                The hall is narrow and dimly lit. The floor is hardwood, with a runner rug down the center.
                The walls have a few framed pictures, and doors lead to other rooms.
                A small table with a vase of wilted flowers sits against one wall.""";


    @Override
    public void getMaterial() {
        System.out.println();
    }

    public String getDescription() {
        return description;
    }
}
