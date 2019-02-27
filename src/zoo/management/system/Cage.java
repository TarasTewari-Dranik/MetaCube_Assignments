package zoo.management.system;

public class Cage {
    private final String typeOfAnimals;
    private final String animalsCategorie;
    private final int animalLimit;
    private Animal [] animals;
    
    public Cage (String animalsType, String categorieOfAnimals, int limit) {
        this.typeOfAnimals = animalsType;
        this.animalsCategorie = categorieOfAnimals;
        this.animalLimit = limit;
        this.animals = new Animal[animalLimit];
    }
    
    public void addAnimal(Animal newAnimal) {
        if (!typeOfAnimals.equals(newAnimal.getAnimalType())) {
            throw new RuntimeException ("Animal can not be added, because animal has another type");
        } else {
            int i=0;
            for (; i < animalLimit; i++) {
                if (animals[i] == null) {
                    animals[i] = newAnimal;
                    break;
                }
                if (animals[i].getId() == newAnimal.getId()) {
                    throw new RuntimeException ("Animal has already been in the cadge");
                }
            }
            if (i == animalLimit) {
                throw new RuntimeException ("No capacity available");
            }
        }
    }
    
    public String getAnimalsCategorie () {
        return this.animalsCategorie;
    }
    
    public int getAnimalLimit () {
        return this.animalLimit;
    }
    
    public String getAnimalType () {
        return this.typeOfAnimals;
    }
    
    public void animalDied (Animal deadAnimal) {
        for (int i=0; i < animalLimit; i++) {
            if (animals[i].getId() == deadAnimal.getId()) {
                animals[i] = null;
                break;
            }
        }
    }
    
    public Animal[] getAllAnimals() {
        return this.animals;
    }
    

}
