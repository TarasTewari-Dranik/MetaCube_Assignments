package zoo.management.system;

public class Mammal extends Animal {
    private static String animalCategorie = "Mammal";
    
    public Mammal(String animalName, String typeOfAnimal, int animalAge, double animalWeight, String animalSound) {
        super (animalName,animalCategorie,typeOfAnimal,animalAge,animalWeight,animalSound);
    }

}
