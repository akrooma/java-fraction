import java.util.*;

/** This class represents fractions of form n/d where n and d are integer 
 * numbers. Basic operations and arithmetics for fractions are provided.
 */
public class Fraction implements Comparable<Fraction> {

   /** Main method. Different tests. */
   public static void main (String[] param) {

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
	   
	   int qcd = 0;
	   int tempA;
	   int tempB;
	   
	   if (a != 0) {
		   if (a < 0)
			   tempA = a * (-1);
		   else 
			   tempA = a;
		   
		   if (b < 0)
			   tempB = b * (-1);
		   else
			   tempB = b;
		   
		   if (a > b) 
			   qcd = calcQCD(tempA, tempB);
		   else if (a < b)
			   qcd = calcQCD(tempB, tempA);
	   }
	   
	   if (qcd != 0) {
		   a = a / qcd;
		   b = b / qcd;
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
   private int calcQCD(int x, int y) {
	   if (y == 0)
		   return x;
	   else
		   return calcQCD(y, x%y);
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
	   sb.append(this.numerator);
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
//	   if (this.denominator == ((Fraction) m).getDenominator()) {
//		   return (this.numerator == ((Fraction) m).getNumerator());
//	   }
//	   
//	   return false;
	   return this.toString().equals(((Fraction) m).toString());
   }

   /** Hashcode has to be equal for equal fractions.
    * @return hashcode
    */
   @Override
   public int hashCode() {
      return 0; // TODO!!!
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
	   int temp = this.numerator;
	   int n = this.denominator;
	   int d = temp;
	   
	   return new Fraction(n, d);
   }

   /** Opposite of the fraction. n/d becomes -n/d.
    * @return opposite of this fraction: -this
    */
   public Fraction opposite() {
	   int n = this.numerator * (-1);
	   
	   return new Fraction(n, this.denominator);
   }

   /** Difference of fractions.
    * @param m subtrahend
    * @return this-m
    */
   public Fraction minus (Fraction m) {
	   int d = this.denominator * m.getDenominator();
	   int n = (this.numerator * m.getDenominator()) - (this.denominator * m.getNumerator());
	   
	   return new Fraction(d, n);
   }

   /** Quotient of fractions.
    * @param m divisor
    * @return this/m
    */
   public Fraction divideBy (Fraction m) throws ArithmeticException {
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
	   int thisN = this.numerator * m.getDenominator();
	   int mN = this.denominator * m.getNumerator();
	   
	   if (thisN < mN) {
		   return -1;
	   } else if (thisN == mN) {
		   return 0;
	   } else {
		   return 1;
	   }
   }

   /** Clone of the fraction.
    * @return new fraction equal to this
    */
   @Override
   public Object clone() throws CloneNotSupportedException {
	   int n = this.numerator;
	   int d = this.denominator;
	   
	   return new Fraction(n, d);
   }

   /** Integer part of the (improper) fraction. 
    * @return integer part of this fraction
    */
   public int integerPart() {
	   if (this.numerator >= this.denominator) {
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
	   int n = (int) f * d;
	   return new Fraction(n, d);
   }

   /** Conversion from string to the fraction. Accepts strings of form
    * that is defined by the toString method.
    * @param s string form (as produced by toString) of the fraction
    * @return fraction represented by s
    */
   public static Fraction valueOf (String s) {
	   s = s.trim().replaceAll("\\s+","");
	   
	   if (!(s.matches("[\\d-/]+")))
		   throw new RuntimeException("String '" + s + "' contains illegal characters.");
	   
	   String [] fraction = s.split("/");
	   
	   return null; // TODO!!!
   }
}

