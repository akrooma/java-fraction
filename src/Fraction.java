import java.util.*;

/** This class represents fractions of form n/d where n and d are integer 
 * numbers. Basic operations and arithmetics for fractions are provided.
 */
public class Fraction implements Comparable<Fraction> {

   /** Main method. Different tests. */
   public static void main (String[] param) {
	   Fraction f = new Fraction(5,3);
	   
//	   System.out.println(calcGCD(300,1));
	   
	   System.out.println(f.fractionPart());
	   
//	   System.out.println(valueOf(s).toString());
   }

	private int numerator;
	private int denominator;

   /** Constructor.
    * @param a numerator
    * @param b denominator > 0
    */
   public Fraction (int a, int b) {	   
	   if (b == 0)
		   throw new RuntimeException("Fraction denominator must be positive.");
	   
	   int gcd;
	   
	   if (a == b)
		   gcd = a;
	   else
		   gcd = calcGCD(a, b);
	
	   if (gcd > 1) {
		   a = a / gcd;
		   b = b / gcd;
	   }
	   
	   if (b < 0 || ((b < 0) && (a < 0))) {
		   a *= -1;
		   b *= -1;
	   }
	 
	   this.numerator = a;
	   this.denominator = b;
   }
   
   /* Leiab suurima ühise kordaja.
    * Info ja pseudokood: https://en.wikipedia.org/wiki/Euclidean_algorithm 
    */
   public int calcGCD(int x, int y) {
	   if (x < 0)
		   x *= -1;
	   
	   if (y < 0)
		   y *= -1;
	   
	   if (y == 0)
		   return x;
	   else
		   return calcGCD(y, x % y);
   }

   /** Public method to access the numerator field. 
    * @return numerator
    */
   public int getNumerator() {
      return numerator;
   }

   /** Public method to access the denominator field. 
    * @return denominator
    */
   public int getDenominator() { 
      return denominator;
   }

   /** Conversion to string.
    * @return string representation of the fraction
    */
   @Override
   public String toString() {
	   StringBuffer sb = new StringBuffer();
	   if (this.numerator < 0) {
		   sb.append("(");
		   sb.append(this.numerator);
		   sb.append(")");
	   } else {
		   sb.append(this.numerator);
	   }
	   
	   sb.append("/");
	   sb.append(this.denominator);
	   
	   return sb.toString();
   }

   /** Equality test.
    * @param m second fraction
    * @return true if fractions this and m are equal
    */
   @Override
   public boolean equals (Object m) {
	   if (m == null)
		   return false;
	   
	   if (m instanceof Fraction) {
		   return this.toString().equals(((Fraction) m).toString());
	   }
	   
	   return false;	   
   }

   //http://javarevisited.blogspot.com.ee/2011/10/override-hashcode-in-java-example.html
   //http://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method
   
   /** Hashcode has to be equal for equal fractions.
    * @return hashcode
    */
   @Override
   public int hashCode() {
	   int hash = 5;
	   hash = 31 * hash + (int) (this.numerator ^ (this.numerator >>> 32));
	   hash = 31 * hash + (int) (this.denominator ^ (this.denominator >>> 32));
	   
	   return hash;
   }

   /** Sum of fractions.
    * @param m second addend
    * @return this+m
    */
   public Fraction plus (Fraction m) {
	   int d = this.denominator * m.getDenominator();
	   int n = (this.numerator * m.getDenominator()) + (this.denominator * m.getNumerator());
	   
	   return new Fraction(n, d);
   }

   /** Multiplication of fractions.
    * @param m second factor
    * @return this*m
    */
   public Fraction times (Fraction m) {
	   int n = this.numerator * m.getNumerator();
	   int d = this.denominator * m.getDenominator();
	   
	   return new Fraction(n, d);
   }

   /** Inverse of the fraction. n/d becomes d/n.
    * @return inverse of this fraction: 1/this
    */
   public Fraction inverse() throws ArithmeticException {
	   return new Fraction(this.denominator, this.numerator);
   }

   /** Opposite of the fraction. n/d becomes -n/d.
    * @return opposite of this fraction: -this
    */
   public Fraction opposite() {
	   return new Fraction((this.numerator * (-1)), this.denominator);
   }

   /** Difference of fractions.
    * @param m subtrahend
    * @return this-m
    */
   public Fraction minus (Fraction m) {
	   int d = this.denominator * m.getDenominator();
	   int n = (this.numerator * m.getDenominator()) - (this.denominator * m.getNumerator());
	   
	   return new Fraction(n, d);
   }

   /** Quotient of fractions.
    * @param m divisor
    * @return this/m
    */
   public Fraction divideBy (Fraction m) throws ArithmeticException {
	   if (this.numerator == 0)
		   throw new RuntimeException("Fraction " + m.toString() + "must have a non-zero numerator");
	   
	   int d = this.denominator * m.getNumerator();
	   int n = this.numerator * m.getDenominator();
	   
	   return new Fraction(n, d);
   }

   /** Comparision of fractions.
    * @param m second fraction
    * @return -1 if this < m; 0 if this==m; 1 if this > m
    */
   @Override
   public int compareTo (Fraction m) {
	   return this.compareTo(m);
   }

   /** Clone of the fraction.
    * @return new fraction equal to this
    */
   @Override
   public Object clone() throws CloneNotSupportedException {
	   return new Fraction(this.numerator, this.denominator);
   }

   /** Integer part of the (improper) fraction. 
    * @return integer part of this fraction
    */
   public int integerPart() {
	   if (this.numerator > this.denominator) {
		   return (this.numerator / this.denominator);
	   }
	   
	   return 0;
   }

   /** Extract fraction part of the (improper) fraction
    * (a proper fraction without the integer part).
    * @return fraction part of this fraction
    */
   public Fraction fractionPart() {
	   if (this.numerator > this.denominator) {
		   int remainder = this.numerator / this.denominator;
		   return new Fraction(remainder, this.denominator);
	   }
	   
	   return new Fraction(this.numerator, this.denominator);
   }

   /** Approximate value of the fraction.
    * @return numeric value of this fraction
    */
   public double toDouble() {
	   return ((double) this.numerator / (double) this.denominator);
   }

   /** Double value f presented as a fraction with denominator d > 0.
    * @param f real number
    * @param d positive denominator for the result
    * @return f as an approximate fraction of form n/d
    */
   public static Fraction toFraction (double f, int d) {
	   return new Fraction(((int) f * d), d);
   }

   /** Conversion from string to the fraction. Accepts strings of form
    * that is defined by the toString method.
    * @param s string form (as produced by toString) of the fraction
    * @return fraction represented by s
    */
   public static Fraction valueOf (String s) {
	   if (!(s.matches("[\\s\\d-/]+")))
		   throw new RuntimeException("Fraction " + s + " contains illegal characters.");
	   
	   s = s.trim().replaceAll("[\\s()]+","");
	   
	   String [] fraction = s.split("/");
	   
	   if (fraction.length > 2)
		   throw new RuntimeException("Fraction " + s + " is an illegal fraction.");
	   
	   Integer n = null;
	   Integer d = null;
	   
	   try {
		   n = Integer.parseInt(fraction[0]);
	   } catch (NumberFormatException e) {
		   throw new NumberFormatException("Couldn't parse expected numerator " + fraction[0]);
	   }
		   
	   try {
		   d = Integer.parseInt(fraction[1]);
	   } catch (NumberFormatException e) {
		   throw new NumberFormatException("Couldn't parse expected denominator " + fraction[1]);
	   }
	   
	   return new Fraction(n, d);
   }
}

