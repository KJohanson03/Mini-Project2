package Package2;

import java.math.BigInteger;
import java.lang.Math;
import java.io.PrintWriter;

/**
 * A simple implementation of Fractions.
 *
 * @author Samuel A. Rebelsky
 * @author Kevin Johanson
 * @version 1.2 of August 2023
 */
public class BigFraction {
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) Denominators are always positive. Therefore, negative fractions are represented
   * with a negative numerator. Similarly, if a fraction has a negative numerator, it
   * is negative.
   *
   * (2) Fractions are not necessarily stored in simplified form. To obtain a fraction
   * in simplified form, one must call the `simplify` method.
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   *
   */
  public BigFraction(BigInteger num, BigInteger denom) {
    this.num = num;
    this.denom = denom;
    simplify();
    } // Fraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   *
   */
  public BigFraction(int num, int denom) {
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
    simplify();
  } // Fraction(int, int)

  /**
   * Build a new fraction by parsing a string.
   *
   */
  public BigFraction(String str) {
	  if (!( str.indexOf("/") == -1)) {
		    String[] splitStr = str.split("/");
		    this.num = new BigInteger(splitStr[0]);
		    this.denom = new BigInteger(splitStr[1]);
		    simplify();
	  } else if ((str.length()) == 0) {   // case for an empty string given
		  this.num = BigInteger.valueOf(0);
	  }
	  else {
		    this.num = BigInteger.valueOf( Integer.valueOf(str));
		    this.denom = BigInteger.valueOf(1);
		    simplify();
	  }
	  

 
  } // Fraction

  /**
   * Builds a new fraction if nothing is given
   *  sets it to 1/1
   */
  public BigFraction() {
    this.num = BigInteger.valueOf(1);
    this.denom = BigInteger.valueOf(1);
    simplify();
  }
  /**
   * Builds a new fraction if just an int is given int/1
   *
   */
  public BigFraction(int numb) {
    this.num = BigInteger.valueOf(numb);
    this.denom = BigInteger.valueOf(1);
    simplify();
  }

  /**
   * Builds a new fraction if a double is given
   *  10.2 = 102/10
   */
  public BigFraction (double numb) {
    String s = String.valueOf(numb);
    int denomLength = (s.length() - 1 ) - s.indexOf('.');
    int tempDenom = 1;  
    double tempNum = numb;

    for (int i = denomLength; i > 0; i--) {
      tempDenom = tempDenom * 10;
      tempNum = tempNum * 10;
    }

    tempNum = tempNum + ((int) numb % 1);
    this.num = BigInteger.valueOf((int)tempNum);
    this.denom = BigInteger.valueOf(tempDenom);
    simplify();
  }
  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+
  /* Simplifies a BigFraction
   * 
   * 
   */
  public void simplify() {
	  PrintWriter pen = new PrintWriter(System.out, true);
	  BigInteger tempNum = this.num;
	  BigInteger tempDenom = this.denom;
	  boolean simplified = false;
	  
	  while (simplified == false) {
		  if ((tempDenom.mod(BigInteger.valueOf(2)) == BigInteger.valueOf(0)) &&
			   tempNum.mod(BigInteger.valueOf(2)) == BigInteger.valueOf(0)) {
			  	tempNum = tempNum.divide(BigInteger.valueOf(2));
			  	tempDenom = tempDenom.divide(BigInteger.valueOf(2));
					  	
		  }else if ((tempDenom.mod(BigInteger.valueOf(3)) == BigInteger.valueOf(0)) &&
				   tempNum.mod(BigInteger.valueOf(3)) == BigInteger.valueOf(0)) {
				  	tempNum = tempNum.divide(BigInteger.valueOf(3));
				  	tempDenom = tempDenom.divide(BigInteger.valueOf(3));
				  	
		  } else if ((tempDenom.mod(BigInteger.valueOf(5)) == BigInteger.valueOf(0)) &&
				   tempNum.mod(BigInteger.valueOf(5)) == BigInteger.valueOf(0)) {
				  	tempNum = tempNum.divide(BigInteger.valueOf(5));
				  	tempDenom = tempDenom.divide(BigInteger.valueOf(5));
				  	
		  }	else if ((tempDenom.mod(BigInteger.valueOf(7)) == BigInteger.valueOf(0)) &&
				   tempNum.mod(BigInteger.valueOf(7)) == BigInteger.valueOf(0)) {
				  	tempNum = tempNum.divide(BigInteger.valueOf(7));
				  	tempDenom = tempDenom.divide(BigInteger.valueOf(7));
		  } else {
			  simplified = true;
		  }
		  
	  }
	  this.num = tempNum;
	  this.denom = tempDenom;
  } // simplify 

  /**
   *
   * Express this fraction as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add the fraction `addMe` to this fraction.
   */
  public BigFraction add(BigFraction addMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  }// add(BigFraction)

  /**
   * subtracts the fraction `subMe` to this fraction.
   */
  public BigFraction subtract(BigFraction subMe) {
	    BigInteger resultNumerator;
	    BigInteger resultDenominator;

	    // The denominator of the result is the
	    // result of this object's denominator
	    // and subMe's denominator subtracted from each other
	    resultDenominator = this.denom.multiply(subMe.denom);
	    // The numerator is more complicated
	    resultNumerator = (this.num.multiply(subMe.denom)).subtract(subMe.num.multiply(this.denom));

	    // Return the computed value
	    return new BigFraction(resultNumerator, resultDenominator);
	  }// subtract(BigFraction)
  
  
  /**
   * Get the denominator of this fraction.
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()
 
  /**
   * Get the numerator of this fraction.
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()
 
  /**
   * Convert this fraction to a string for ease of printing.
   */
  public String toString() {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero

    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()

  public BigFraction multiply( BigFraction second ) {

	  return new BigFraction(
			  this.num.multiply(second.num),
			  this.denom.multiply(second.denom));
  } // end multiply
  
  public BigFraction divide(BigFraction second) {
		 
		 return new BigFraction(
				 this.num.multiply(second.denom),
				 this.denom.multiply(second.num));
	 }
  public BigFraction fractional() {

	  return new BigFraction(this.num.mod(this.denom), this.denom );
  } // end fractional function
  
  public static void main(String args[]) {
	  
	   BigFraction test = new BigFraction("1/2");
	   System.out.println(test);
	
	   System.out.println(test.subtract(new BigFraction("1/2")));

	   System.out.println(test.add(new BigFraction("1/2")));
  }
  
} // end BigFraction


