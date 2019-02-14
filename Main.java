package specification.assignment.strings.operation;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.print("Compare two strings and return 1 if equals else 0."+"\n");
        Scanner userFirstString = new Scanner(System.in);
        System.out.print("Enter first string: "+"\n");
        String firstString = userFirstString.nextLine();
        Scanner userSecondString = new Scanner(System.in);
        System.out.print("Enter second string: "+"\n");
        String secondString = userSecondString.nextLine();
        System.out.print(new StringOperation().stringComparison(firstString, secondString)+"\n");
        System.out.print("Return the reverse string, replace lowercase characters with uppercase and vice-versa, return the largest word of a string."+"\n");
        Scanner userString = new Scanner(System.in);
        System.out.print("Enter string: "+"\n");
        String operationString = userString.nextLine();
        System.out.print("The reverse string: "+new StringOperation().reverseString(operationString)+"\n");
        System.out.print("Lowercase characters with uppercase and vice-versa "+ new StringOperation().replaceCharacters(operationString)+"\n");
        System.out.print("Largest word: "+new StringOperation().largestWord(operationString)+"\n");
    }
}
