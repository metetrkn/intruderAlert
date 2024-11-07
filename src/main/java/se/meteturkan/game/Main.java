package se.meteturkan.game;

import java.util.Scanner;
import se.meteturkan.common.OptionController;


public class Main{
    private final static Scanner scanner = new Scanner(System.in); // Instantiating scanner object and dependency injection
    private final static OptionController controller = new OptionController(scanner); // Instantiating option controller object and dependency injection

    public static void main(String[] args) {
        Game game = new Game(scanner, controller); // Creating an instance of game class
        game.initMenu(); // Initializing menu option
        game.initGame(); // Initializing fighting
    }
}