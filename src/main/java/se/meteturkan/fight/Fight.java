package se.meteturkan.fight;

import se.meteturkan.characters.Entity;
import se.meteturkan.characters.Residence;
import se.meteturkan.characters.Burglar;
import se.meteturkan.common.OptionController;
import se.meteturkan.game.Menu;
import java.util.Scanner;

public class Fight {
    private static boolean running = true; // Control the fight loop
    private final Menu menu; // Dependency injection, declaring menu
    private OptionController optionController; // Creating OptionController object with scanner as parameter
    private static Scanner scanner;
    private Burglar burglar;
    private Residence residence;



    public Fight(OptionController optionController, Scanner scanner, Menu menu, Burglar burglar, Residence residence) {
        this.optionController = optionController;
        this.scanner = scanner;
        this.menu = menu;
        this.burglarBaseHealth = burglar.getHealt(); // Initialize the base health of burglar
        this.burglar = burglar;
        this.residence = residence;
        this.residenceBaseHealth = 0;
    }




    private final float burglarBaseHealth; // Store initial health of the burglar
    private float residenceBaseHealth; // Store initial health of the residence


    // Execute an attack from attacker to defender
    private void executeAttack(Entity attacker, Entity defender) {
        // Prints a series of fire characters for visual effect
        System.out.println("🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥");

        attacker.punch(defender); // Attacker attacks defender

        // Check if defender is still alive
        if (defender.isConscious()) {
            float currentHealth = defender.getHealt();
            float baseHealth = (defender == burglar) ? burglarBaseHealth : residenceBaseHealth;
            System.out.println(defender.getName() + " has " + currentHealth + "/" + baseHealth + " health left.");
        }

        System.out.println("🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥\n\n\n\n");
    }


    // Execute one round of fighting, residence attacks first!
    private void fightOneRound() {
        executeAttack(residence, burglar); // Residence attacks burglar
        if (burglar.isConscious()) {
            executeAttack(burglar, residence); // Burglar attacks residence if alive
        }
    }


    // Start the fight loop
    public void startFight() {
        while (running && burglar.isConscious() && residence.isConscious()) {
            System.out.println("\nChoose an action:\n1 - Attack\n2 - Exit\n"); // Prompt user
            int input = optionController.checker(1,2); // Prompting user until inputs a valid option

            if (input == 1) {
                fightOneRound(); // Execute a round of fighting
            } else {
                menu.exitSystem(); // Exiting messages
                running = false; // Exit the fight loop
            }
        }

        // Check final health status
        if (!burglar.isConscious()) {
            printNeutralizedMessage("burglar");
        } else if (!residence.isConscious()) {
            printNeutralizedMessage("residence");
        }
    }


    // Method to print neutralization message
    private void printNeutralizedMessage(String entity) {
        String skull = "\uD83D\uDC80\uD83D\uDC80\t\t\t\t\t\t\t\t\t\uD83D\uDC80\uD83D\uDC80";
        System.out.println(skull);
        System.out.printf("\"\"The %s has been neutralized. RIP!\"\"\n", entity);
        System.out.println(skull);
    }
}
