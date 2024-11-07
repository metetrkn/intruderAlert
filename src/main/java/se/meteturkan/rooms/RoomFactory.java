package se.meteturkan.rooms;


import se.meteturkan.game.Menu;
import java.util.Scanner;

public class RoomFactory {
    // Factory method to create Room instances
    public static Room createRoom(String roomType, Scanner scanner, Menu menu) {
        switch (roomType) {
            case "LivingRoom":
                return new LivingRoom(scanner, menu);
            case "Kitchen":
                return new Kitchen(scanner, menu);
            case "Hall2":
                return new Hall2(scanner, menu);
            case "Bedroom":
                return new Bedroom(scanner, menu);
            case "Hall":
                return new Hall(scanner, menu);
            case "EmptyRoom":
                return new EmptyRoom(scanner, menu);
            case "Bathroom":
                return new Bathroom(scanner, menu);


            // Add other room types here
            default:
                throw new IllegalArgumentException("Unknown room type: " + roomType);
        }
    }
}
