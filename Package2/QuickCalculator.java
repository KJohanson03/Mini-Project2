package Package2;

import java.io.PrintWriter;

public class QuickCalculator {
	
	public static void main(String[] args) {
		
		PrintWriter pen = new PrintWriter(System.out, true);
		BFCalculator calc = new BFCalculator();
		
		
		for (int i = 0; i < args.length; i ++) {
			if (args[i].length() >= 5 && args[i].substring(0,5).equals("STORE")) {
				String argArr[] = args[i].split("\\s+"); 
				calc.store(argArr[1].charAt(0));
			} else {
				pen.println(args[i] + " = " + calc.evaluate(args[i]));
			}
			
		}
		

		/*
		PrintWriter pen = new PrintWriter(System.out, true);
		
		BigFraction test = new BigFraction("4/4");
		test.add(test);
		test = new BigFraction("44");

		BFCalculator read = new BFCalculator();
	    pen.println("eval = " + read.evaluate("4 + 4 + 4"));
	    read.store('c');
	    pen.println(read.storeValue);
	    
	    pen.println("eval test = " + read.evaluate("c + c + c"));
	    
		*/

	}
}
