package se.meteturkan.fight;

import se.meteturkan.characters.Entity;
import se.meteturkan.characters.Residence;
import se.meteturkan.characters.Burglar;
import se.meteturkan.common.OptionController;
import se.meteturkan.game.Menu;
import java.util.Scanner;
import java.util.Random;

public class Fight {
    private static boolean running = true; // Control the fight loop
    private final Menu menu; // Dependency injection, declaring menu
    private final Random random;
    private final OptionController controller; // Creating OptionController object with scanner as parameter
    private final Scanner scanner;
    private final Burglar burglar;
    private final Residence residence;
    private final float burglarBaseHealth; // Store initial health of the burglar
    private final float residenceBaseHealth; // Store initial health of the residence



    public Fight(OptionController optionController, Scanner scanner, Menu menu, Burglar burglar,
                 Residence residence, Random random) {
        this.controller = optionController;
        this.scanner = scanner;
        this.menu = menu;
        this.burglar = burglar;
        this.residence = residence;
        this.burglarBaseHealth = burglar.getHealt(); // Initialize the base health of burglar
        this.residenceBaseHealth = residence.getHealt();
        this.random = random;
    }


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
        menu.printStringWithDelay( "\nYou confront the burglar, his face concealed by a mask,\n" +
                                           "yet you can hear his ragged, menacing breath. The air is thick with tension.\n" +
                                           "It's time for a fight!\n", 20);
        while (running && burglar.isConscious() && residence.isConscious()) {
            System.out.println("\nChoose an action:\n1 - Attack\n2 - Exit\n"); // Prompt user
            int input = controller.checker(1,2); // Prompting user until inputs a valid option

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

        // If the resident neutralizes the burglar, prompt to call the police.
        if (entity.equals("residence")) {
            menu.printStringWithDelay("\n\nYou died and your entire house was stolen!", 10);
            menu.exitSystem(); // Game closes with farewell messages
        }
    }
}