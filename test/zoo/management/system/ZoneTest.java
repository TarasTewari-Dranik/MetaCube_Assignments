package zoo.management.system;

import org.junit.Test;
import static org.junit.Assert.*;

public class ZoneTest {
    
    @Test
    public void createZoneTest () {
        Zone mammalZone = new Zone ("Mammal", 10, false, true);
        int cagesAmount = 10;
        assertEquals(cagesAmount,mammalZone.getAllCages().length);
        assertEquals(true,mammalZone.getHasCanteen());
    }
    
    @Test (expected = RuntimeException.class)
    public void addCageTest () {
        Zone mammalZone = new Zone ("Mammal", 10, false, true);
        Cage lionCage = new Cage("Lion", "Mammal", 20);
        mammalZone.addCage(lionCage);
        Cage peacockCage = new Cage("Peacock", "Bird", 2);
        mammalZone.addCage(peacockCage);
    }

}
