package zoo.management.system;

import org.junit.Test;
import static org.junit.Assert.*;

public class CageCreationTest {
    
    @Test
    public void createCageTest (){
        Cage crocodilesCage = new Cage("Crocodile", "Reptile", 10);
        int result = 10;
        assertEquals(result,crocodilesCage.getAllAnimals().length);
    }
    
    @Test (expected = RuntimeException.class)
    public void cageOverloadTest () {
        Cage lionCage1 = new Cage("Lion", "Mammal", 20);
        for (int i=0; i < 20; i++) {
            Lion lion = new Lion("Lion"+i, 1+i, 80+i, "roars");
            lionCage1.addAnimal(lion);
        }
        Lion extraLion = new Lion("LionExtra", 1, 80.0, "roars");
        lionCage1.addAnimal(extraLion);
    }
    
    @Test (expected = RuntimeException.class)
    public void animalAddToCageTest () {
        Cage peacockCage1 = new Cage("Peacock", "Bird", 2);
        Peacock jupi = new Peacock("Jupi", 3, 15,"hhh");
        peacockCage1.addAnimal(jupi);
        peacockCage1.addAnimal(jupi);
    }
    
    @Test 
    public void animalDeathTest () {
        Cage peacockCage2 = new Cage("Peacock", "Bird", 2);
        Peacock jupi = new Peacock("Jupi", 3, 15,"hhh");
        peacockCage2.addAnimal(jupi);
        peacockCage2.animalDied(jupi);
        Peacock [] animals = new Peacock [2];
        assertArrayEquals(animals,peacockCage2.getAllAnimals());
    }

}
