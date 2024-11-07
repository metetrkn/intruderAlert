package se.meteturkan.rooms;


import se.meteturkan.game.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public abstract class Room {
    private String roomDescription;
    private String roomName;
    private List<Room> connectedRooms = new ArrayList<>();
    private Scanner scanner;
    private Menu menu;


    // Constructor for using dependency injection
    public Room(Scanner scanner, Menu menu) {
        this.scanner = scanner;
        this.menu = menu;
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

    // Method to connect this room to another room
    public void connectRoom(Room room) {
        connectedRooms.add(room);
    }


    // Usual method to print out rooms description
    public abstract void describeRoom();


    // Material
    public abstract void getMaterial();
}
