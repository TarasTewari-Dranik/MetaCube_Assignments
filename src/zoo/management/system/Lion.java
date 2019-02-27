package zoo.management.system;

public class Lion extends Mammal{
    private static String animalType = "Lion";

    public Lion(String animalName, int animalAge, double animalWeight, String animalSound) {
        super (animalName, animalType, animalAge, animalWeight, animalSound);
    }

}
