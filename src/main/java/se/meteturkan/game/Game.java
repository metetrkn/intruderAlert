package se.meteturkan.game;

import java.util.Random;
import java.util.Scanner;
import se.meteturkan.common.OptionController;
import se.meteturkan.fight.Fight;
import se.meteturkan.rooms.Room;
import se.meteturkan.rooms.RoomFactory;
import java.util.HashMap;


public class Game {
    private Scanner scanner; // Declare scanner for dependency injection
    private OptionController controller; // Declare OptionController for dependency injection
    private Menu menu = new Menu(); // Creating an instance of menu class
    private Fight fight;
    private Room residenceCurrentRoom;
    private Room burglarCurrentRoom;
    private Random random = new Random();



    // Constructor
    public Game(Scanner scanner, OptionController controller) {
        this.scanner = scanner;
        this.controller = controller; // Initialize OptionController with the injected scanner
        this.fight = new Fight(controller, scanner); // Initializing fight with the injected OptionController

        // Initialize rooms
        initializeRooms();
    }

    // Initializing rooms
    private void initializeRooms() {
        // Create rooms using the factory method
        Room livingRoom = RoomFactory.createRoom("LivingRoom", scanner, menu);
        Room kitchen = RoomFactory.createRoom("Kitchen", scanner, menu);
        Room bedroom = RoomFactory.createRoom("Bedroom",scanner, menu);
        Room bathroom = RoomFactory.createRoom("Bathroom",scanner, menu);
        Room emptyroom = RoomFactory.createRoom("EmptyRoom",scanner, menu);
        Room hall = RoomFactory.createRoom("Hall",scanner, menu);
        Room hall2 = RoomFactory.createRoom("Hall2",scanner, menu);

        // Connecting rooms based on house plan
/**
                             (BATHROOM)   <==>    (EMPTY ROOM)
                                 ^                      ^
                                ||                     ||
                                v                      v
         (KITCHEN)   <==>  (LIVING ROOM)  <==>      (HALL)
            ^                   ^
           ||                  ||
           v                   v
         (HALL-2)    <==>  (BEDROOM)
*/
        // Connecting living room to related rooms
        livingRoom.connectRoom(kitchen);
        livingRoom.connectRoom(bathroom);
        livingRoom.connectRoom(hall);
        livingRoom.connectRoom(bedroom);

        // Connecting bathroom to related rooms
        bathroom.connectRoom(livingRoom);
        bathroom.connectRoom(emptyroom);

        // Connecting empty room to related rooms
        emptyroom.connectRoom(bathroom);
        emptyroom.connectRoom(hall);

        // Connecting hall to related rooms
        hall.connectRoom(livingRoom);
        hall.connectRoom(emptyroom);

        // Connecting bedroom to related rooms
        bedroom.connectRoom(livingRoom);
        bedroom.connectRoom(hall2);

        // Connecting hall-2 to related rooms
        hall2.connectRoom(bedroom);
        hall2.connectRoom(kitchen);

        // Connecting kitchen to related rooms
        kitchen.connectRoom(hall2);
        kitchen.connectRoom(livingRoom);


        // Setting starting rooms of gamers
        this.residenceCurrentRoom = livingRoom;
        this.burglarCurrentRoom = emptyroom;
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
                map.put(roomNum, connectedRoom); // Creating hashmap for future use - players choice
                roomNum++;
            }

            int randomRoom = 1 + random.nextInt(roomNum - 1); // Getting random room number from hashmap automatically for burglar
            burglarCurrentRoom = map.get(randomRoom); // Burglar goes to next room (randomly chosen)
            System.out.printf("\nThere are some creaking sounds coming from %s\n\n", burglarCurrentRoom.getRoomName());


            // Resetting hashmap and room
            roomNum = 1;
            map.clear();

            System.out.printf("Residence is currently at: %s",  residenceCurrentRoom.getRoomName() + "\n"); // Residence current location in house
            System.out.println("Where you want to go next?\n"); // Prompting user to choice where to go next

            // Looping through all connected rooms to current one for residence
            for (Room connectedRoom : residenceCurrentRoom.getConnectedRooms()) {
                System.out.println(roomNum + " - " + connectedRoom.getRoomName()); // Listing rooms
                map.put(roomNum, connectedRoom); // Creating hashmap for future use - players choice
                roomNum++;
            }

            // Prompting user to input next rooms choice
            System.out.print("\nNext room: ");
            residenceCurrentRoom = map.get(scanner.nextInt());


            // A fight begins if the residence and burglar are in the same room
            if (residenceCurrentRoom == burglarCurrentRoom) {
                fight.startFight(); // Init fight
                break;
            }
        }
    }


    // Initialize fight
    public void initGame() {
        tourRooms(); // Traveling through rooms until players meet and fight against each other
    }
}
