package se.meteturkan.fight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.meteturkan.characters.Burglar;
import se.meteturkan.characters.Residence;

public class EntityConsciousTest {

    @Test
    public void testEntityConsciousStateAfterAttack() {
        // Creating instances of Burglar and Residence with initial values
        Burglar burglar = new Burglar("Burglar", 30, 20, 5);
        Residence residence = new Residence("Resident", 50, 15, 8);

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
