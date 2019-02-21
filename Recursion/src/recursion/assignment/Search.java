package recursion.assignment;

public class Search {
    /**
     * Linear Search. It sequentially checks each element of the array for the target value until a match is found or until all the elements have been searched.
     * @param arrayOfElements Integer array where to search.
     * @param elementToSearch Integer an element to be search in array
     * @throws Error if aaray is empty or No match is found
     * @return Integer index where element occurs in array
     */
    public int linearSearch (int[] arrayOfElements, int elementToSearch) {
        if (arrayOfElements.length == 0) throw new AssertionError("Array is empty.");
        int index = 0;
        return elementLinearSearch (arrayOfElements,elementToSearch,index);
    }
    
    private int elementLinearSearch (int[] arrayOfElements, int elementToSearch, int index) {

        if (index >= arrayOfElements.length) throw new AssertionError ("No match is found");
        if (arrayOfElements[index] == elementToSearch) return index;
        return elementLinearSearch(arrayOfElements,elementToSearch,index+1);
    }
    /**
     * Binary Search. Binary search compares the target value to the middle element of the array. If they are not equal, the half in which the target cannot lie is eliminated and the search continues on the remaining half, again taking the middle element to compare to the target value, and repeating this until the target value is found.
     * @param arrayOfElements Integer array of sorted elements.
     * @param elementToSearch an element to be search in array
     * @throws Error if aaray is empty or No match is found
     * @return Integer index where element occurs in array
     */
    public int binarySearch (int[] arrayOfElements, int elementToSearch) {
        if (arrayOfElements.length == 0) throw new AssertionError("Array is empty.");
        int beginning = 0;
        int end = arrayOfElements.length;
        return elementBinarySearch (arrayOfElements,elementToSearch,beginning,end);
    }
    
    private int elementBinarySearch (int[] arrayOfElements, int elementToSearch, int beginning, int end){
        int middle = (beginning+end)/2;
        if (arrayOfElements[middle] != elementToSearch && (middle == 0 || middle == arrayOfElements.length-1)) throw new AssertionError ("No match is found");
        if (arrayOfElements[middle] == elementToSearch) return middle;
        if (arrayOfElements[middle] < elementToSearch ) return elementBinarySearch (arrayOfElements, elementToSearch, middle, end);
        return elementBinarySearch (arrayOfElements, elementToSearch, beginning, middle);
                
    }
}
