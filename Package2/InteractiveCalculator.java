package Package2;

import java.io.PrintWriter;
import java.util.Scanner;


/**
 * Implements a calculator that calculates expressions without PEMDAS in the read in lines.
 *
 * @author Kevin Johanson
 * @version 1.2 of August 2023
 */
public class InteractiveCalculator {

	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in); //input stream	
		PrintWriter pen = new PrintWriter(System.out, true); // printwriter object for printing
		BFCalculator calc = new BFCalculator();		
		String stopper = "";
		
		pen.println("Welcome to Interactive calculator. Type in QUIT to stop");
		
		while (!(stopper.equals("QUIT"))) {
			System.out.print("Enter your expression : ");  
			String str= sc.nextLine();              //reads string   
			if (str.equals("QUIT")) { // checks if stop is entered
			    pen.println("program ended");
			    stopper = "QUIT";
			}else if (str.length() >= 5 && str.substring(0,5).equals("STORE")) {
				String splitStore[] = str.split("\\s+"); 
				calc.store(splitStore[1].charAt(0));
			} else { 
				pen.println(str + " = " + calc.evaluate(str));// prints the expression + the answer
			}
		}

		
		
		for (int i = 0; i < args.length; i ++) {
			if (args[i].length() >= 5 && args[i].substring(0,5).equals("STORE")) {
				String argArr[] = args[i].split("\\s+"); 
				calc.store(argArr[1].charAt(0));
			} else {
				pen.println(args[i] + " = " + calc.evaluate(args[i]));
			}
			

		}

	}
}
