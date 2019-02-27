package zoo.management.system;

public class Reptile extends Animal{
    private static String animalCategorie = "Reptile";
    
    public Reptile (String animalName, String typeOfAnimal, int animalAge, double animalWeight, String animalSound) {
        super (animalName,animalCategorie,typeOfAnimal,animalAge,animalWeight,animalSound);
    }

}
