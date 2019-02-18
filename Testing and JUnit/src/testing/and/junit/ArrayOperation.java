package testing.and.junit;

public class ArrayOperation {
    /**
     * Return the size of the largest mirror section found in the input array;
     * @param operationArray input array of Integers;
     * @throws NullPointerException if input array is empty;
     * @return Integer maximumMirror is the size of the largest mirror section;
     */
    public static Integer maxMirror (Integer[] operationArray){
        
        int maximumMirror = 0;
        
        if (operationArray.length == 0){
            throw new NullPointerException("Array is empty.");
        } else {
            
            for (int i=0; i < operationArray.length; i++){
                int counter = 0;
                
                for (int j = operationArray.length-1; j >= 0 && i+counter < operationArray.length;j--){
                    
                    if (operationArray[i+counter] == operationArray[j]) {
                        counter++;
                    } else {
                        maximumMirror = Math.max(maximumMirror, counter);
                        counter = 0;
                    }
                }
                maximumMirror = Math.max(maximumMirror, counter);
            }
        }
        return maximumMirror;
    }
    
    /**
     * Return the number of clumps in the input array;
     * @param operationArray input array of Integers;
     * @throws NullPointerException if input array is empty;
     * @return Integer countArrayClumps is number of clumps;
     */
    public static Integer countClumps (Integer[] operationArray){
        
        int countArrayClumps = 0;
        boolean indicator = true;
        
        if (operationArray.length == 0){
            throw new NullPointerException("Array is empty.");
        } else {
            
            for (int i=1; i < operationArray.length; i++){
                
                if (operationArray[i-1] == operationArray[i]&&indicator){
                    countArrayClumps+=1;
                    indicator = false;
                } else if (operationArray[i-1] != operationArray[i]){
                    indicator = true;
                }
            }
        }
        
        return countArrayClumps;
    }
    
    /**
     * Return an array that contains exactly the same numbers as the input array, but rearranged so that every X is immediately followed by a Y.
     * @param operationArray input array of Integers;
     * @param x Integer value from the array which y should follow;
     * @param y Integer value is following x;
     * @throws AssertionError if If array is empty; If there are unequal numbers of X and Y in input array; If two adjacents X values are there; If X occurs at the last index of array.
     * @return Rearranged array of Integers;
     */
    public static Integer[] fixXY (Integer[] operationArray, Integer x, Integer y){
        
        if (operationArray.length == 0){
            throw new AssertionError ("Array is empty.");
        } else {
            
            int j=0;
            for (int i = 0; i < operationArray.length; i++){
                
                if (operationArray[i] == x && (i == operationArray.length - 1 || operationArray[i+1] == x)){
                    throw new AssertionError();
                } else if ( operationArray[i] == x && operationArray[i+1] != y) {
                    
                    for (; j < operationArray.length ; j++) {
                        
                        if (operationArray[j] == y && (j == 0 || operationArray[j-1] != x)) {
                            operationArray [j] = operationArray[i+1];
                            operationArray[i+1] = y;
                            break;
                        } else if (j == operationArray.length -1 ){
                            throw new AssertionError();
                        }
                    }
                }
            }
        }
        return operationArray;
    }
    
    /**
     * Return the index if there is a place to split the input array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side else return -1.
     * @param operationArray input array of Integers;
     * @throws NullPointerException if input array is empty;
     * @return Integer splitElement is the index if there is a place to split, or -1 if array can not be slit
     */
    public static Integer splitArray (Integer[] operationArray){
        
        int sumLeftSide = 0;
        int splitElement = -1;
        
        if (operationArray.length == 0){
            throw new NullPointerException("Array is empty.");
        } else {
            
            for (int i = 0; i < operationArray.length; i++){
                
                sumLeftSide = sumLeftSide + operationArray[i];
                int sumRightSide = 0;
                
                for (int j=operationArray.length-1; j > i; j--){
                    sumRightSide = sumRightSide + operationArray [j];
                }
                if (sumLeftSide == sumRightSide){
                    splitElement = i+1;
                    break;
                } 
            }
        }
        
        return splitElement;
    }
}
