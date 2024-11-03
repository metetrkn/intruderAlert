package se.meteturkan.fight;


import se.meteturkan.characters.Entity;
import se.meteturkan.characters.Residence;
import se.meteturkan.characters.Burglar;
import se.meteturkan.common.OptionController;
import java.util.Scanner;


public class Fight {
    private static boolean running = true; // Control the fight loop
    private OptionController optionController; // Creating OptionController object with scanner as parameter
    private static Scanner scanner;



    // Declaring burglar instance as a concrete subclass
    private static Burglar burglar = new Burglar("Burglar", "Burglar", 80, 10, 4);
    private Residence residence; // Declare residence without initializing


    private final float burglarBaseHealth; // Store initial health of the burglar
    private float  residenceBaseHealth; // Store initial health of the residence


    public Fight(OptionController optionController, Scanner scanner) {
        this.optionController = optionController;
        this.scanner = scanner;
        this.burglarBaseHealth = burglar.getHealt(); // Initialize the base health of burglar
        // Initialize the base health of residence to 0 initially, it will be set in initializeResidence()
        this.residenceBaseHealth = 0;
    }


    // Method to initialize residence with user input
    private void initializeResidence() {
        System.out.print("Enter the name of the residence: ");
        String residenceName = scanner.nextLine(); // Get user input for the residence name
        residence = new Residence(residenceName, "Residence", 100, 10, 4); // Initialize with user input

        // Set residenceBaseHealth to the initial health of residence
        this.residenceBaseHealth = residence.getHealt();
    }


    // Execute an attack from attacker to defender
    private void executeAttack(Entity attacker, Entity defender) {
        attacker.punch(defender); // Attacker attacks defender

        // Prints a series of fire characters for visual effect
        System.out.println("🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥");

        // Print the attack action
        System.out.println("\n" + attacker.getName() + " hits ===> " + defender.getName() + " ("
                + (attacker.getAttackPoint()) + " Attack point)!");

        // Check if defender is still alive
        if (defender.isConscious()) {
            float currentHealth = defender.getHealt();
            float baseHealth = (defender == burglar) ? burglarBaseHealth : residenceBaseHealth;
            System.out.println(defender.getName() + " has " + currentHealth + "/" + baseHealth + " health left.\n");
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
        initializeResidence(); // Prompt user for residence name

        while (running && burglar.isConscious() && residence.isConscious()) {
            System.out.println("\nChoose an action:\n1 - Attack\n2 - Run\n"); // Prompt user
            int input = optionController.checker(1, 2); // Prompting user until inputs a valid option

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
