package abstr.and.cocrete.data.types;

import java.util.stream.IntStream;

/**
 * Implement the immutable class intSet using an array to represent a set of integers in the range 1-1000.
 * @author tarasdranik
 *
 */
public final class intSet {
    
    private final int[] arraySet;
    
    public intSet (int[] array){
        int [] operationalArray = arrayOperation(array);
        this.arraySet = operationalArray;
    }
    
    public int getElement (int i) {
        return this.arraySet[i];
    }
    //Makes a deep copy of the initial array
    private int[] arrayOperation (int[] newArray) {
        
        int[] noDuplicates = IntStream.of(newArray).distinct().toArray();
        int[] data = new int[noDuplicates.length];
        for (int i=0; i < data.length; i++) {
            data[i] = noDuplicates[i];
        }
        return data;
        
    }
    
    public int size() {
        return arraySet.length;
    }
    /**
     * Check whether x is a member of the set and return a boolean value
     * @param x Integer number 
     * @return boolean true if x is a member of the set, false if not
     */
    public boolean isMember(int x) {
        for (int element:arraySet) if (element == x) return true;
        return false;
    }
    
    /**
     * Check whether s is a subset of the set
     * @param s intSet set of integers
     * @return  boolean true if s is subset of the set, false if not
     */
    
    public boolean isSubSet(intSet s) {
        return s.isSetIsSubSet(arraySet);
    }
    
    /**
     * Set of members that belong to the second (universal) set "and not" the first set
     * @return Array of Integers -  the complement set, where 1..1000 is the universal set
     */
    
    public int[] getComplement() {
        int[] universalSet = new int[1000];
        for (int i = 0; i < universalSet.length; i++) {
            universalSet[i] = i+1;
        }
        
        int[] complement = new int[universalSet.length - arraySet.length];
        int counter = 0;
        for (int element:universalSet) {
            
            if (isMember(element) == false){
                complement[counter] = element;
                counter += 1;
            }
        }
        
        return complement;
    }
    
    /**
     * Set of members that belong to the first set "or" the second set. 
     * @param s Integer Set 
     * @return Set of Integers which contains elements of the first set or the second set
     */
    
    public int[] union(intSet s) {
        int[] joiningArray = new int[s.size()+arraySet.length];
        for (int i=0; i < arraySet.length; i++) {
            joiningArray[i] = arraySet[i];
            System.out.println(arraySet[i]);
        }
        for (int j=0; j < s.size(); j++) {
            joiningArray[arraySet.length+j] = s.getElement(j);
            System.out.println(s.getElement(j));
        }
        int[] unionSet = IntStream.of(joiningArray).distinct().toArray();
        return unionSet;
    }
    
    //Access each element of the sets and checkin if they are equal to each other or not
    
    private boolean isSetIsSubSet (int[] array) {
        if (arraySet.length > array.length) return false;
        int counter = 0;
        for (int element:arraySet) {
            for (int j = 0; j < array.length; j++) {
                if (element == array[j]) {
                    counter+=1;
                    break;
                }
            }
        }
        if (counter == arraySet.length ) return true;
        return false;
    }
    
    
    
}
