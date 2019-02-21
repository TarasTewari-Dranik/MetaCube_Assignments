package recursion.assignment;

public class LcmAndHcf {
    /**
     * Calculates Highest Common Factor of to integers
     * @param firstNumber Integer number
     * @param secondNumber Integer number
     * @return Integer which represent Highest Common Factor
     */
    
    //Using Euclidean algorithm we keep subtracting repeatedly the larger of two, we end up with HCF
    public int highestCommonFactor (int firstNumber, int secondNumber) {
        if (firstNumber == 0) return secondNumber;
        if (secondNumber == 0) return firstNumber;
        if (firstNumber == secondNumber) return firstNumber;
        if (firstNumber > secondNumber) return highestCommonFactor(firstNumber - secondNumber,secondNumber );
        return highestCommonFactor(firstNumber,secondNumber - firstNumber);
        
    }
    
    /**
     * Calculates Least Common Multiple using Highest Common Factor
     * @param firstNumber Integer number
     * @param secondNumber Integer number
     * @return Integer which represent Least Common Multipler
     */
    public int leastCommonMultiple (int firstNumber, int secondNumber){
        return (firstNumber*secondNumber)/highestCommonFactor(firstNumber, secondNumber);
    }

}
