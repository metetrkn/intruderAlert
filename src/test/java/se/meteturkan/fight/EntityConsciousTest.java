package se.meteturkan.fight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.meteturkan.characters.Burglar;
import se.meteturkan.characters.Residence;
import java.util.Random;

public class EntityConsciousTest {
    Random random = new Random(); // Instantiating random object for test

    @Test
    public void testEntityConsciousStateAfterAttack() {
        // Creating instances of Burglar and Residence with initial values
        Burglar burglar = new Burglar("Burglar", 80, 12, 4, random);
        Residence residence = new Residence("Residence", 100, 7, 5, random);

        // Burglar attacks Residence
        burglar.punch(residence);

        // Verify Residence is still conscious
        assertTrue(residence.isConscious(), "Resident should still be conscious.");

        // Burglar attacks Residence until it's unconscious
        while (residence.isConscious()) {
            burglar.punch(residence);
        }

        // Verify Residence is no longer conscious
        assertFalse(residence.isConscious(), "Resident should no longer be conscious.");
    }
}
