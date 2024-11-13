package se.meteturkan.game;

import java.util.Scanner;
import se.meteturkan.common.OptionController;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { // try-with-resources ensures Scanner obj closes automatically
            Game game = new Game(scanner, new OptionController(scanner)); // Creating an instance of game class with dependency injection
            game.initMenu(); // Initializing menu option
            game.tourRooms(); // Initializing fighting
        }
    }
}
