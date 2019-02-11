package hexademical.arithmetic;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



class HexCalc {
	
	public String decimalToHexadecimal (int decimalNumber){
		int hexCoefficient = 16;
		List<Character> hexadecimalNumber = new ArrayList<>();
		List<Character> hexadecimalSeries = Arrays.asList(new Character[] {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'});
		int divisionResult = decimalNumber;
		int remainder = 0;
		while (divisionResult!=0){
			remainder  = divisionResult%hexCoefficient;
			divisionResult = divisionResult/hexCoefficient;
			hexadecimalNumber.add(0,hexadecimalSeries.get(remainder));
		}
		
		return hexadecimalNumber.stream().map(String::valueOf).collect(Collectors.joining());
	}
	
	public int hexadecimalToDecimal (String hexadecimalNumber){
		int hexCoefficient = 16;
		int decimalNumber = 0;
		String hexadecimalNumberLowerCase = hexadecimalNumber.toLowerCase();
		List<Character> hexadecimalSeries = Arrays.asList(new Character[] {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'});
		//char[] hexadecimalSeries = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char[] hexadecimalNumberToConvert = hexadecimalNumberLowerCase.toCharArray();
		
		int order = 0;
		for (int i = hexadecimalNumberToConvert.length-1; i >= 0 ; i--){
		    decimalNumber=decimalNumber+hexadecimalSeries.indexOf(hexadecimalNumberToConvert[order]) * (int) (Math.pow(hexCoefficient, i));
		    order +=1;
		}
		return decimalNumber;
	}
	
	public boolean hexademicalStringCompareEqual(String hexadecimalNumberA, String hexadecimalNumberB){
		hexadecimalNumberA.toLowerCase();
		hexadecimalNumberB.toLowerCase();
		if (hexadecimalNumberA.equals(hexadecimalNumberB)){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hexademicalStringCompareGreaterThan(String hexadecimalNumberA, String hexadecimalNumberB){
		hexadecimalNumberA.toLowerCase();
		hexadecimalNumberB.toLowerCase();
		if (hexadecimalNumberA.length()>hexadecimalNumberB.length()) {
			return true;
		} else if (hexadecimalNumberA.length()==hexadecimalNumberB.length() && hexadecimalNumberA.compareTo(hexadecimalNumberB)>0){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hexademicalStringCompareLessThan(String hexadecimalNumberA, String hexadecimalNumberB){
		hexadecimalNumberA.toLowerCase();
		hexadecimalNumberB.toLowerCase();
		if (hexadecimalNumberA.length()>hexadecimalNumberB.length()) {
			return false;
		} else if (hexadecimalNumberA.length()==hexadecimalNumberB.length() && hexadecimalNumberA.compareTo(hexadecimalNumberB)>=0){
			return false;
		} else {
			return true;
		}
	}
	
	public String addHexadecimalNumbers (String hexadecimalNumberA, String hexadecimalNumberB ) {
		
		int decimalNumberA = hexadecimalToDecimal(hexadecimalNumberA);
		 int decimalNumberB = hexadecimalToDecimal(hexadecimalNumberB);
		 
		 return decimalToHexadecimal(decimalNumberA+decimalNumberB);
		
	}
	
	public String substractHexadecimalNumbers (String hexadecimalNumberA, String hexadecimalNumberB ) {
		
		int decimalNumberA = hexadecimalToDecimal(hexadecimalNumberA);
		int decimalNumberB = hexadecimalToDecimal(hexadecimalNumberB);
		
		if (decimalNumberA>decimalNumberB) {
			
			return decimalToHexadecimal(decimalNumberA-decimalNumberB);
			
		} else {
			
			return decimalToHexadecimal(decimalNumberB-decimalNumberA);
			
		}
		
	}
	
	public String multiplyHexadecimalNumbers (String hexadecimalNumberA, String hexadecimalNumberB ) {
		
		int decimalNumberA = hexadecimalToDecimal(hexadecimalNumberA);
		int decimalNumberB = hexadecimalToDecimal(hexadecimalNumberB);
		 
		return decimalToHexadecimal(decimalNumberA*decimalNumberB);
		
	}
	
	public String divideHexadecimalNumbers (String hexadecimalNumberA, String hexadecimalNumberB ) {
		
		int decimalNumberA = hexadecimalToDecimal(hexadecimalNumberA);
		int decimalNumberB = hexadecimalToDecimal(hexadecimalNumberB);
		
		if (decimalNumberA>decimalNumberB && decimalNumberA%decimalNumberB==0){
			return decimalToHexadecimal(decimalNumberA/decimalNumberB);
		} else {
			
			return ("Try Another Pare Of Hexadecimal Numbers, First Number is smaller than Second Or Result Is Not Integer Number");
		
		}
		
	}

	
	
}
