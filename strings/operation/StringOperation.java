package specification.assignment.strings.operation;

public class StringOperation {

    static Character[] lowerCase = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static Character[] upperCase = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    /**
     * Convert string to character array
     * @param s not empty string to convert
     * @return array of characters from the string
     */
    public Character[] stringToCharacterArray(String s) {
        Character[] array = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
           array[i] = s.charAt(i);
        }
//        for (int i = 0; i < array.length; i++){
//            System.out.println(array[i]);
//        }
        return array;
     }
    /**
     * Compare two string and return 1 if equal and O if not equal
     * @param firstString first string for comparison
     * @param secondString second string for comparison
     * @return integer comparisonResult which of comparison 
     */
    public int stringComparison(String firstString, String secondString){
        Character[] firstStringCharacters = stringToCharacterArray(firstString);
        Character[] secondStringCharacters = stringToCharacterArray(secondString);
        int comparisonResult = 1;
        if (firstStringCharacters.length != secondStringCharacters.length) {
            comparisonResult = 0;
        } else {
            for (int i = 0; i < firstStringCharacters.length;i++){
                if (firstStringCharacters[i] != secondStringCharacters[i]){
                    comparisonResult = 0;
                }
            }
        }
        return comparisonResult;
    }
    /**
     * Return the reverse of any string
     * @param s not empty string to reverse
     * @return string reverseString
     */
    public String reverseString (String s){
        Character[] stringToReverse = stringToCharacterArray(s);
        String reverseString = new String();
        for (int i = stringToReverse.length-1; i >=0; i--){
            reverseString = reverseString+stringToReverse[i];
        }
        return reverseString;
    }
    /**
     * Receive a string as parameter and replace lowercase characters with uppercase and vice-versa.
     * @param s not empty string
     * @return string replaceCharactersString where lowercase characters are now uppercase characters and vice-versa
     */
    public String replaceCharacters (String s){
        Character[] characterString = stringToCharacterArray(s);
        for (int j=0; j < characterString.length; j++) {
            for (int i=0; i < lowerCase.length; i++){
                if (characterString[j] == lowerCase[i]){
                    characterString[j] = upperCase[i];
                    break;
                } else if (characterString[j] == upperCase[i]){
                    characterString[j] = lowerCase[i];
                    break;
                }
            }
        }
        String replaceCharactersString = new String();
        for (int j=0; j < characterString.length; j++){
            replaceCharactersString  = replaceCharactersString +characterString[j];
        }
        return replaceCharactersString;
    }
    /**
     * Return the largest word of a string.
     * @param s not empty string
     * @return string largestWordInString with largest word
     */
    public String largestWord (String s){
        Character[] characterString = stringToCharacterArray(s);
        String largestWordInString = new String();
        String counterString = new String();
        int counter = 0;
        int wordLength = 0;
        for (int j=0; j < characterString.length; j++){
            for (int i=0; i < lowerCase.length; i++){
                if ((characterString[j] == lowerCase[i] || characterString[j] == upperCase[i]) && j == characterString.length && counter >= wordLength){
                    counterString = counterString +characterString[j];
                    largestWordInString = new String(counterString);
                } else if ((characterString[j] == lowerCase[i] || characterString[j] == upperCase[i]) && j < characterString.length-1){
                    counter = counter+1;
                    counterString = counterString +characterString[j];
                    break;
                } else if (i == lowerCase.length-1 && counter >= wordLength){
                    wordLength = counter;
                    counter = 0;
                    largestWordInString = new String(counterString);
                    counterString = new String ("");
                }
            }
        }
        
        return largestWordInString;
    }
}
