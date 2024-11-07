package se.meteturkan.rooms;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public abstract class Room {
    private String description;
    private String roomName;
    private List<Room> connectedRooms = new ArrayList<>();
    private Scanner scanner;
    private Materials materials;



    // Constructor for using dependency injection
    public Room(Scanner scanner) {
        this.scanner = scanner;
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

    // Room describing
    public abstract String getDescription();

    // Material
    public abstract void getMaterial();
}
