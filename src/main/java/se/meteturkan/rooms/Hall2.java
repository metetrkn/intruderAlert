package se.meteturkan.rooms;

import se.meteturkan.common.OptionController;
import se.meteturkan.game.Menu;

import java.util.Scanner;

public class Hall2 extends Room {
    // Constructor
    public Hall2(Scanner scanner, Menu menu, OptionController controller) {
        super(scanner, menu, controller); // Pass dependencies to the abstract class constructor
        setRoomName("hall-2");
    }

    private String description = """
                 Hall-2 is slightly wider with brighter lighting.
                 The floor is tiled, and there are a few coat hooks on the wall, some with jackets hanging.
                 A narrow bench sits along one side, and a small window at the end provides natural light.""";



    @Override
    public boolean getMaterial() {
        System.out.println();
        return  false;
    }

    public String getDescription() {
        return description;
    }
}
