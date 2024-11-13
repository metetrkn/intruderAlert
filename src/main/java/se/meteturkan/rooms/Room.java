package se.meteturkan.rooms;

import se.meteturkan.common.OptionController;
import se.meteturkan.game.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Room {
    private String roomName;
    private List<Room> connectedRooms = new ArrayList<>();
    Scanner scanner; // Removed initialization
    Menu menu;
    OptionController controller; // Removed initialization
    private Materials materials = new Materials(); // Instantiating material

    // Constructor for using dependency injection
    public Room(Scanner scanner, Menu menu, OptionController controller) {
        this.scanner = scanner;
        this.menu = menu;
        this.controller = controller; // These are now passed from the subclass
    }

    // Getter method
    public List<Room> getConnectedRooms() {
        return connectedRooms;
    }

    public String getRoomName() {
        return roomName;
    }

    // Setter method
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    // Method to connect this room to one or multiple rooms
    public void connectRooms(Room... rooms) {
        for (Room room : rooms) {
            connectedRooms.add(room);
        }
    }

    // Room describing
    public abstract String getDescription();

    // Material
    public abstract boolean getMaterial();
}
