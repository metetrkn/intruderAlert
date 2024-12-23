package se.meteturkan.game;

import java.util.Random;
import java.util.Scanner;

import se.meteturkan.characters.Burglar;
import se.meteturkan.characters.Residence;
import se.meteturkan.common.OptionController;
import se.meteturkan.fight.Fight;
import se.meteturkan.rooms.Room;
import se.meteturkan.rooms.RoomFactory;
import java.util.HashMap;


public class Game {
    private Scanner scanner; // Declare scanner for dependency injection
    private OptionController controller; // Declare OptionController for dependency injection
    private Fight fight;
    private Room residenceCurrentRoom;
    private Room burglarCurrentRoom;
    private Random random = new Random();
    private Menu menu = new Menu(); // Creating an instance of menu class


    // Declaring burglar instance as a concrete subclass
    private Burglar burglar = new Burglar("Burglar", 80, 12, 4, random);
    private Residence residence = new Residence("Residence", 100, 7, 5, random);


    // Constructor
    public Game(Scanner scanner, OptionController controller) {
        this.scanner = scanner;
        this.controller = controller; // Initialize OptionController with the injected scanner
        this.fight = new Fight(controller, scanner, menu, burglar, residence, random); // Initializing fight with the injected OptionController

        // Initialize rooms
        initializeRooms();
    }

    // Initializing rooms
    private void initializeRooms() {
        // Create rooms using the factory method
        Room livingRoom = RoomFactory.createRoom("LivingRoom", scanner, menu, controller);
        Room kitchen = RoomFactory.createRoom("Kitchen", scanner, menu, controller);
        Room bedroom = RoomFactory.createRoom("Bedroom",scanner, menu, controller);
        Room bathroom = RoomFactory.createRoom("Bathroom",scanner, menu, controller);
        Room office = RoomFactory.createRoom("Office",scanner, menu, controller);
        Room hall = RoomFactory.createRoom("Hall",scanner, menu, controller);
        Room hall2 = RoomFactory.createRoom("Hall2",scanner, menu, controller);

        // Connecting rooms based on house plan
        /**
                            (BATHROOM)   <==>    (OFFICE)
                                ^                   ^
                               ||                  ||
                               v                   v
         (KITCHEN)   <==>  (LIVING ROOM)  <==>      (HALL)
          ^                   ^
         ||                  ||
         v                   v
         (HALL-2)    <==>  (BEDROOM)
         */
        // Connecting rooms based on house plan
        livingRoom.connectRooms(kitchen, bathroom, hall, bedroom);
        bathroom.connectRooms(livingRoom, office);
        office.connectRooms(bathroom, hall);
        hall.connectRooms(livingRoom, office);
        bedroom.connectRooms(livingRoom, hall2);
        hall2.connectRooms(bedroom, kitchen);
        kitchen.connectRooms(hall2, livingRoom);

        // Setting starting rooms of gamers
        this.residenceCurrentRoom = livingRoom;

        // Burglar starts from office but in game mechanics its next choice by random
        // will be either 'hall' or 'bathroom' and game starts there
        // Burglar initial room is either "hall" or "bathroom"
        this.burglarCurrentRoom = office;
    }

    // Initializing menu operations
    public void initMenu() {
        menu.welcomingMessage(); // Printing out welcoming message
        menu.loginMenu(); // Printing out login menu

        // Prompting user to login or exit
        int result = controller.checker(1, 2);

        if (result == 1) {
            menu.printStringWithDelay("\nLogging in...", 100); // Delayed printing out
        } else {
            menu.exitSystem(); // Exiting message
            System.exit(0); // Closing the system
        }
    }


    // Simulating residence and burglar moving around rooms
    public void tourRooms() {
        boolean keepRunning = true;
        // Creating hash map for room choice, <Room num - Room name>
        HashMap<Integer, Room> map = new HashMap<>();

        while (keepRunning) {
            int roomNum = 1; // Beginning key for rooms in hashmap

            // Looping through all connected rooms to current one for burglar
            for (Room connectedRoom : burglarCurrentRoom.getConnectedRooms()) {
                map.put(roomNum++, connectedRoom);
            }

            int randomRoom = 1 + random.nextInt(roomNum - 1); // Getting random room number from hashmap automatically for burglar
            burglarCurrentRoom = map.get(randomRoom); // Burglar goes to next room (randomly chosen)


            // If burglar is alive, keeps reporting its position each turn
            if (burglar.isConscious()) {
                menu.printStringWithDelay("\nThere are some creaking sounds coming from " + burglarCurrentRoom.getRoomName() + "\n\n", 10);
            }


            // Resetting hashmap and room
            map.clear();
            roomNum = 1;

            menu.printStringWithDelay("Residence is currently at: " + residenceCurrentRoom.getRoomName() + "\n\n", 10);
            System.out.println("❂".repeat(64));
            menu.printStringWithDelay(residenceCurrentRoom.getDescription(), 10);
            System.out.println("❂".repeat(64));

            // If there is a material in current room and user takes it
            if (residenceCurrentRoom.getMaterial()) {
                residence.increaseAttack(15);
            };

            System.out.println("Where do you want to go next?\n"); // Prompting user to choose where to go next

            // Looping through all connected rooms to current one for residence
            for (Room connectedRoom : residenceCurrentRoom.getConnectedRooms()) {
                System.out.println(roomNum + " - " + connectedRoom.getRoomName());
                map.put(roomNum++, connectedRoom);
            }

            // Exit option
            System.out.println("0 - Exit\n");

            // Prompting user to input next room choice
            int userChoice = controller.checker(0, roomNum); // User's next room choice as int

            // Exiting the game if user choice to exit (0)
            if (userChoice == 0) {
                menu.exitSystem();
            }

            residenceCurrentRoom = map.get(userChoice); // Updating user's current room as choice

            // A fight begins if the residence and burglar are in the same room
            if (residenceCurrentRoom == burglarCurrentRoom && burglar.isConscious() && residence.isConscious()) {
                fight.startFight(); // Init fight
            }
        }
    }
}

