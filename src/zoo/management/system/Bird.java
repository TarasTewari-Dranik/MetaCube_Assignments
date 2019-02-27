package zoo.management.system;

public class Bird extends Animal {
    private static String animalCategorie = "Bird";
    
    public Bird (String animalName, String typeOfAnimal, int animalAge, double animalWeight, String animalSound) {
        super (animalName,animalCategorie,typeOfAnimal,animalAge,animalWeight,animalSound);
    }

}
