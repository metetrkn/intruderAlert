package se.meteturkan.rooms;


import se.meteturkan.common.OptionController;
import se.meteturkan.game.Menu;
import java.util.Scanner;

public class RoomFactory {
    // Factory method to create Room instances
    public static Room createRoom(String roomType, Scanner scanner, Menu menu, OptionController controller) {
        switch (roomType) {
            case "LivingRoom":
                return new LivingRoom(scanner, menu, controller);
            case "Kitchen":
                return new Kitchen(scanner, menu, controller);
            case "Hall2":
                return new Hall2(scanner, menu, controller);
            case "Bedroom":
                return new Bedroom(scanner, menu, controller);
            case "Hall":
                return new Hall(scanner, menu, controller);
            case "Office":
                return new Office(scanner, menu, controller);
            case "Bathroom":
                return new Bathroom(scanner, menu, controller);


            // Add other room types here
            default:
                throw new IllegalArgumentException("Unknown room type: " + roomType);
        }
    }
}
