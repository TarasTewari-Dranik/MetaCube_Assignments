package hexademical.arithmetic;
import javax.swing.JOptionPane;


class UI {
	
	HexCalc calculate = new HexCalc();
	
	private Integer choise;
	
	public UI () {
        menu();
    }
	
	private int getUserInput(){
		String[] action = { "1.Convert Hexadecimal To Decimal", 
							"2.Convert Decimal To Hexadecimal", 
							"3.Add Two Hexadecimal Numbers", 
							"4.Substract Two Hexadecimal Numbers", 
							"5.Multiply Two Hexadecimal Numbers",
							"6.Divide Two Hexadecimal Numbers",
							"7.Compare Two Hexadecimal Numbers",
							"8.Nothing" };
		String whatToDo = (String) JOptionPane.showInputDialog(null,"What do you want to do?","Action",JOptionPane.QUESTION_MESSAGE, null, action,action[0]);
		choise = Character.getNumericValue(whatToDo.charAt(0));
		return choise;
	
	}
	
	public void menu () {
        do {
            getUserInput();
            switch (choise) {
                case 1: 
                    convertHexToDec();
                    break;
                case 2:
                    convertDecToHex();
                    break;
                case 3:
                	addTwoHex();
                	break;
                case 4:
                	substractTwoHex();
                	break;
                case 5:
                	multiplyTwoHex();
                	break;
                case 6:
                	divideTwoHex();
                	break;
                case 7:
                	compareTwoHex();
                case 8:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (choise != 0);
    }
	
	private void convertHexToDec() {
		String hexNumber = JOptionPane.showInputDialog("Provide Hexadecimal Number");
		int decimalNumber = calculate.hexadecimalToDecimal(hexNumber);
		JOptionPane.showMessageDialog(null, "The Decimal Number of the Hexadecimal "+hexNumber+" is "+decimalNumber);
	}
	
	private void convertDecToHex() {
		String inputNumber = JOptionPane.showInputDialog("Provide Hexadecimal Number");
		int decimalNumber = Integer.parseInt(inputNumber);
		JOptionPane.showMessageDialog(null, "The Hexadecimal Number of the Decimal "+decimalNumber+" is "+calculate.decimalToHexadecimal(decimalNumber));
	}
	
	private void addTwoHex() {
		String firstHexNumber = JOptionPane.showInputDialog("Provide First Hexadecimal Number");
		String secondHexNumber = JOptionPane.showInputDialog("Provide Second Hexadecimal Number");
		JOptionPane.showMessageDialog(null, "The Sum Of Two Hexadecimal Number is "+calculate.addHexadecimalNumbers(firstHexNumber, secondHexNumber));
	}
	
	private void substractTwoHex() {
		String firstHexNumber = JOptionPane.showInputDialog("Provide First Hexadecimal Number");
		String secondHexNumber = JOptionPane.showInputDialog("Provide Second Hexadecimal Number");
		JOptionPane.showMessageDialog(null, "The Difference Of Two Hexadecimal Number is "+calculate.substractHexadecimalNumbers(firstHexNumber, secondHexNumber));
	}
	
	private void multiplyTwoHex() {
		String firstHexNumber = JOptionPane.showInputDialog("Provide First Hexadecimal Number");
		String secondHexNumber = JOptionPane.showInputDialog("Provide Second Hexadecimal Number");
		JOptionPane.showMessageDialog(null, "The Multiplication Of Two Hexadecimal Number is "+calculate.multiplyHexadecimalNumbers(firstHexNumber, secondHexNumber));
	}
	
	private void divideTwoHex() {
		String firstHexNumber = JOptionPane.showInputDialog("Provide First Hexadecimal Number");
		String secondHexNumber = JOptionPane.showInputDialog("Provide Second Hexadecimal Number");
		JOptionPane.showMessageDialog(null, "The Division Of Two Hexadecimal Number is "+calculate.divideHexadecimalNumbers(firstHexNumber, secondHexNumber));
	}
	
	private void compareTwoHex() {
		Integer localChoise = null;
		String firstHexNumber = JOptionPane.showInputDialog("Provide First Hexadecimal Number");
		String secondHexNumber = JOptionPane.showInputDialog("Provide Second Hexadecimal Number");
		String[] action = { "1.Two Hexadecimal Numbers Are Equal?", 
							"2.First Hexadecimal Number Is Greatr Than Second?", 
							"3.First Hexadecimal Number Is Less Than Second?", 
							"4.Nothing" };
		do {
			String compare = (String) JOptionPane.showInputDialog(null,"What do you want to Check?","Comparison Of Two Hexadecimal Numbers",JOptionPane.QUESTION_MESSAGE, null, action,action[0]);
			localChoise = Character.getNumericValue(compare.charAt(0));
            switch (localChoise) {
                case 1: 
                	JOptionPane.showMessageDialog(null,calculate.hexademicalStringCompareEqual(firstHexNumber,secondHexNumber));
                    break;
                case 2:
                	JOptionPane.showMessageDialog(null,calculate.hexademicalStringCompareGreaterThan(firstHexNumber,secondHexNumber));
                    break;
                case 3:
                	JOptionPane.showMessageDialog(null,calculate.hexademicalStringCompareLessThan(firstHexNumber,secondHexNumber));
                	break;
                case 4:
                	menu ();
                default:
                    break;
            }
        } while (localChoise != 0);
		
	}

}
