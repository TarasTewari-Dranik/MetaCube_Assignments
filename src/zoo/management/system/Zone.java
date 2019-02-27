package zoo.management.system;

public class Zone {
    private final String animalCategorie;
    private final int cagesLimit;
    private Cage [] cages;
    private int cagesNumber;
    private boolean hasPark;
    private boolean hasCanteen;
    
    public Zone(String categorieOfAnimals, int limit, boolean park, boolean canteen) {
        this.animalCategorie = categorieOfAnimals;
        this.cagesLimit = limit;
        this.cages = new Cage[cagesLimit];
        this.hasPark = park;
        this.hasCanteen = canteen;
    }
    // Checks Limit and if limit is not reached add cage to the zone.
    public void addCage(Cage newCage) {
        if (cagesNumber > cagesLimit) {
            throw new RuntimeException ("No capacity available");
        }
        if (animalCategorie.equals(newCage.getAnimalsCategorie())) {
            cages[cagesNumber] = newCage;
            cagesNumber++;
        } else {
            throw new RuntimeException ("Animal category mismatch");
        }
    }
    
    public boolean getHasPark () {
        return this.hasPark;
    }
    
    public boolean getHasCanteen () {
        return this.hasCanteen;
    }
    
    public int getCagesLimit () {
        return this.cagesLimit;
    }
    
    public Cage[] getAllCages() {
        return this.cages;
    }
    

}
