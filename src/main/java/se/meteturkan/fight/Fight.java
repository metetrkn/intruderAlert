package se.meteturkan.fight;

import org.w3c.dom.ls.LSOutput;
import se.meteturkan.characters.Entity;
import se.meteturkan.characters.Residence;
import se.meteturkan.characters.Burglar;
import se.meteturkan.common.OptionController;

import java.util.Scanner;


public class Fight {
    private static boolean running = true; // Control the fight loop
    private OptionController optionController; // Creating OptionController object with scanner as parameter
    private static Scanner scanner;

    // Declaring residence instance as a concrete subclass
    private static Residence residence = new Residence("mete","Residence", 100, 50, 30);
    // Declaring burglar instance as a concrete subclass
    private static Burglar burglar = new Burglar("Burglar", "Burglar", 80, 30, 40);



    public Fight(OptionController optionController, Scanner scanner) {
        this.optionController = optionController;
        this.scanner = scanner;
    }


    // Execute an attack from attacker to defender
    static void executeAttack(Entity attacker, Entity defender) {
        final int defenderBaseHealth = defender.getHealt();
        attacker.punch(defender); // Attacker attacks defender

        // Print the attack action
        System.out.println("\n" + attacker.getRole() + " hits ===> " + defender.getRole() + " ("
                + (attacker.getAttackPoint()- defender.getDefensePoint()) + " Attack point)!");

        // Check if defender is still alive
        if (defender.isConscious()) {
            System.out.println(defender.getRole() + " has " + defender.getHealt()
                    + "/" + defenderBaseHealth + " health left.\n");
        }
    }


    // Execute one round of fighting, residence attacks first!
    private static void fightOneRound() {
        executeAttack(residence, burglar); // Residence attacks burglar
        if (burglar.isConscious()) {
            executeAttack(burglar, residence); // Burglar attacks residence  if alive
        }
    }


    // Start the fight loop
    public void startFight() {
        while (running && burglar.isConscious() && residence.isConscious()) {
            System.out.println("\"Choose an action:\n1 - Attack\n2 - Run\n"); // Prompt user
            int input = optionController.checker(1,2); // Prompting user until inputs a valid option


            if (input == 1) {
                fightOneRound(); // Execute a round of fighting
            } else {
                System.out.println("You have chosen to run away!");
                running = false; // Exit the fight loop
            }
        }


        // Check final health status
        if (!burglar.isConscious()) {
            System.out.println("\n\"\"The burglar has been neutralized. RIP!\"\"");
        } else if (!residence.isConscious()) {
            System.out.println("\n\"\"The residence has been neutralized. RIP!\"\"");
        }
    }
}
