package zoo.management.system;

public abstract class Animal {
    public static int idGenerator = 1000000000;
    private final int id;
    private final String name;
    private final String animalCategorie;
    private final String animalType;
    private int age;
    private double weight;
    private String sound;
    
    public Animal (String animalName, String categorieOfAnimal, String typeOfAnimal, int animalAge, double animalWeight, String animalSound) {
        this.id = idGenerator++;
        this.name = animalName;
        this.animalCategorie = categorieOfAnimal;
        this.animalType = typeOfAnimal;
        this.age = animalAge;
        this.weight = animalWeight;
        this.sound = animalSound;
    }
    
    public void setAnimalAge (int ageOfAnimal) {
        this.age = ageOfAnimal;
    }
    
    public void setAnimalWeight (double weightOfAnimal) {
        this.weight = weightOfAnimal;
    }
    
    public void setAnimalSound (String soundOfAnimal) {
        this.sound = soundOfAnimal;
    }
    
    public int getId () {
        return id;
    }
    
    public String getName () {
        return name;
    }
    
    public String getAnimalCategorie () {
        return animalCategorie;
    }
    
    public String getAnimalType () {
        return animalType;
    }
    
    public int getAge () {
        return age;
    }
    
    public double getWeight () {
        return weight;
    }
    
    public String getSound () {
        return sound;
    }
    

}
