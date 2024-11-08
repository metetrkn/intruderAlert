package se.meteturkan.fight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.meteturkan.characters.Burglar;
import se.meteturkan.characters.Residence;

public class FightTest {

    @Test
    public void testPunchAttack() {
        // Creating instances of Burglar and Residence with initial values
        Burglar burglar = new Burglar("Burglar", 80, 12, 4);
        Residence residence = new Residence("Residence", 100, 7, 5);

        // Health of Residence before attack
        float initialHealth = residence.getHealt();

        // Store initial defense of Residence before attack (for special move check)
        float initialDefense = residence.getDefensePoint();

        // Burglar attacks Residence
        burglar.punch(residence);

        // Health of Residence after attack
        float healthAfterAttack = residence.getHealt();

        // Calculate the actual damage taken
        float damageTaken = initialHealth - healthAfterAttack;


        // Burglar ap = 12 - residence dp = 5 = (12-5)*[0.5-1.5] min 3.5,
        // if special move activated Burglar ap + 20 = 32 - residence dp = 5 = (12-5)*[0.5-1.5] max 40.5,
        assertTrue(damageTaken >= 3.5 && damageTaken <= 40.5, "Damage should be between 3.5 and 10.5. Actual damage: " + damageTaken);
    }
}
