package se.meteturkan.rooms;


import se.meteturkan.common.OptionController;
import se.meteturkan.game.Menu;

import java.util.Scanner;

public class LivingRoom extends Room {
    // Constructor
    public LivingRoom(Scanner scanner, Menu menu, OptionController controller) {
        super(scanner, menu, controller); // Pass dependencies to the abstract class constructor
        setRoomName("living room");
        //setConnectedRooms();
    }

    private String description = """
                       The living room is spacious with a cozy sofa and a coffee table in the center.
                       A TV sits on a stand against one wall, with a few books and magazines scattered around.
                       The floor is covered with a soft rug, and a lamp provides warm light.
                       A window lets in natural light, and family photos hang on the walls.""";

    @Override
    public void getMaterial() {
        System.out.println();
    }

    public String getDescription() {
        return description;
    }
}
