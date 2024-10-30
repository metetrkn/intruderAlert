package se.meteturkan.game;

import java.util.Scanner;
import se.meteturkan.common.OptionController;
import se.meteturkan.fight.Fight;


public class Game {
    private Scanner scanner; // Declare scanner for dependency injection
    private OptionController controller; // Declare OptionController for dependency injection
    private Menu menu = new Menu(); // Creating an instance of menu class
    private Fight fight;


    // Constructor
    public Game(Scanner scanner, OptionController controller) {
        this.scanner = scanner;
        this.controller = controller; // Initialize OptionController with the injected scanner
        this.fight = new Fight(controller, scanner); // Initializing fight with the injected OptionController
    }


    // Initializing menu operations
    public void initMenu() {
        menu.welcomingMessage(); // Printing out welcoming message
        menu.loginMenu(); // Printing out login menu

        // Prompting user to login or exit
        int result = controller.checker(1, 2);

        if (result == 1) {
            menu.printStringWithDelay("Logging in...", 30); // Delayed printing out
        } else {
            menu.exitSystem(); // Exiting message
            System.exit(0); // Closing the system
        }
    }


    // Initialize fight
    public void initFight() {
        fight.startFight(); // Starts fight until one player gets down
    }
}
