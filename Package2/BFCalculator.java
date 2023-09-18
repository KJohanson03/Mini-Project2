package Package2;

public class BFCalculator {

	BigFraction storeValue; // the last value
	BigFraction registerValue; // the value that gets printed out when the register char is called
	
	char storeChar;
	
	/* Evaluates a String expression (no PEMDAS);
	 * 
	 * 
	 */
	public BigFraction evaluate(String exp) {
		BigFraction value = new BigFraction(0);

		String exprSplit[] = exp.split("\\s+"); // splits the expression using spaces into an array
		if (exprSplit[0] == "") {  // if expression is empty return 0
			return value;
		} else {// sets the initial value to the first number in the expression if the expression has a length
			if (exprSplit[0].length() == 1 && (exprSplit[0].charAt(0) == storeChar)) { // checks to see if the first value in the expression is the store value
			
				value = (registerValue);
			} else {
			value = new BigFraction(exprSplit[0]);
			}
		}

		for (int i = 0; i < exprSplit.length ; i++) { // traverse through split string expression

			if( ((int) exprSplit[i].charAt(0)) >= 48 && ((int) exprSplit[i].charAt(0)) <= 57 ) { // checks to see if array index is a #


			} else if (exprSplit[i].equals("+")) { // calls BigFractions add function if + is found

				if (exprSplit[i+1].length() == 1 && (exprSplit[i+1].charAt(0) == storeChar)) { // checks to see if the value after the symbol in the expression is the store value
					value = value.add(registerValue);
				} else {
					value = value.add(new BigFraction(exprSplit[i+1]));
				}
			} else if (exprSplit[i].equals("-")) { // calls BigFractions subtract function if - is found


				if (exprSplit[i+1].length() == 1 && (exprSplit[i+1].charAt(0) == storeChar)) { // checks to see if the value after the symbol in the expression is the store value
					value = value.subtract(registerValue);
				} else {
					value = value.subtract(new BigFraction(exprSplit[i+1]));
				}
				
			} else if (exprSplit[i].equals("/")) { // calls BigFractions divide function if / is found


				if (exprSplit[i+1].length() == 1 && (exprSplit[i+1].charAt(0) == storeChar)) { // checks to see if the value after the symbol in the expression is the store value
					value = value.divide(registerValue);
				} else {
				value = value.divide(new BigFraction(exprSplit[i+1]));
				}
				
			} else if (exprSplit[i].equals("*")) { // calls BigFractions multiply function if * is found


				if (exprSplit[i+1].length() == 1 && (exprSplit[i+1].charAt(0) == storeChar)) { // checks to see if the value after the symbol in the expression is the store value
					value = value.multiply(registerValue);
				} else {
				value = value.multiply(new BigFraction(exprSplit[i+1]));
				}
				
			}
			
		}
		storeValue = value;
		return value;
	}
	/*
	 * sets storeChar to the char given 
	 * 
	 */
	public void store(char register) {
		storeChar = register;
		registerValue = storeValue;
		
	}
	


}
